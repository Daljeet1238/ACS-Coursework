/* Name: Daljeet Singh
 * Student ID: 3169763
 * Assignment Part II 
 * 
 */

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>
#include <string.h>

#define BUFFER_SIZE 10
#define SLEEP_TIME_SECS 2
#define BUFFER_ITEM_SIZE 10
#define DATA_NUMBER_TO_PRODUCE 5

//Shared buffer and semaphores
char buffer[BUFFER_SIZE][BUFFER_ITEM_SIZE];
int in = 0;
int out = 0;

// semaphores
sem_t empty;		// tracking empty slots
sem_t full;			// tracking filled slots
sem_t mutex;		// mutual exclusive for buffer access

// producer thread function
void* thread_producer ( void* arg ){
	int id = *(int*)arg;
	free(arg);
	
	for (int i = 0; i < DATA_NUMBER_TO_PRODUCE; i++){
		sleep(SLEEP_TIME_SECS);		// sleep before producing
		
		sem_wait(&empty);
		sem_wait(&mutex);
		
		snprintf(buffer[in], BUFFER_ITEM_SIZE, "%d-%d", id, i);
		in = (in + 1) % BUFFER_SIZE;
		
		sem_post(&mutex);
		sem_post(&full);
		
		// message printed outside critical section
		printf("producer %d generates data %d-%d\n", id, id, i);
		
	}
	return NULL;
}

// consumers thread function
void* thread_consumer(void* arg) {
	int id = *(int*)arg;
	free(arg);
	
	while (1) {
		char item[BUFFER_ITEM_SIZE];
		int prod_id, item_id;
		
		sem_wait(&full);
		sem_wait(&mutex);
		
		snprintf(item, BUFFER_ITEM_SIZE, "%s", buffer[out]);
		out = (out + 1) % BUFFER_SIZE;
		
		sem_post(&mutex);
		sem_post(&empty);
		
		if (strcmp(item, "END") == 0) {
			break;
		}
		
		sscanf(item, "%d-%d", &prod_id, &item_id);
		
		// printed outside critical sections
		printf("consumer %d eats data = %d-%d\n", id, prod_id, item_id);
	}
	return NULL;
}

int main (int argc, char *argv[]) {
	if (argc < 3) {
		printf ("producer/consumer with semaphores require 2 arguments\n");
		printf ("usage: assign03_pc <# producers> <# consumers> \n");
		return 1;
	}
	
	int num_producers = atoi(argv[1]);
	int num_consumers = atoi(argv[2]);
	
	if (num_producers == 0 && num_consumers > 0){
		printf ("0 producers, %d consumers: Consumers will wait indefinitely for data. \n", num_consumers);
		return 0;
	}
	
	if (num_producers > 0 && num_consumers == 0){
		printf("%d producer, 0 consumers: data can be produced, but nobody eat it, so the program would block once the buffer becomes full.\n", num_producers);
		return 0;
	}
	
	
	sem_init(&empty, 0, BUFFER_SIZE);
	sem_init(&full, 0, 0);
	sem_init(&mutex, 0, 1);
	
	pthread_t *prods = malloc(num_producers * sizeof(pthread_t));
	pthread_t *cons = malloc(num_consumers * sizeof(pthread_t));
	
	// create producers threads
	for (int i = 0; i < num_producers; i++){
		int* id = malloc(sizeof(int));
		*id = i;
		pthread_create(&prods[i], NULL, thread_producer, id);
	}
	
	// creates consumers threads
	for (int i = 0; i < num_consumers; i++) {
		int* id = malloc(sizeof(int));
		*id = i;
		pthread_create(&cons[i], NULL, thread_consumer, id);
	}
	
	// wait for producers to finish
	for (int i = 0; i < num_producers; i++){
		pthread_join(prods[i], NULL);
	}
	
	printf ("Producers ended!\n");
	
	//send one end item to each consumer so they can stop
	for (int i = 0; i < num_consumers; i++){
		sem_wait(&empty);
		sem_wait(&mutex);
		
		snprintf(buffer[in], BUFFER_ITEM_SIZE, "END");
		in = (in + 1) % BUFFER_SIZE;
		
		sem_post(&mutex);
		sem_post(&full);
	}
	
	for (int i = 0; i < num_consumers; i++){
		pthread_join(cons[i], NULL);
	}
	
	sem_destroy(&empty);
	sem_destroy(&full);
	sem_destroy(&mutex);
	
	free(prods);
	free(cons);
	
	return 0;
	
}

