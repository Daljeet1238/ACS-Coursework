// Daljeet Singh
// 3169763
// Part III

#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>

sem_t mutex;

//thread1
void *thread_hi_nosem(void *arg){
	for (int i=0; i<200; i++){
		printf(".");
	}
	
	printf(" hi there\n");
	sem_post(&mutex);
	
	return NULL;
	
}

//thread2
void *thread_Daljeet_nosem(void *arg){
	sem_wait(&mutex);
	
	for (int i=0; i<200; i++){
		printf("x");
	}
	
	printf(" Daljeet Singh\n");
	return NULL;
	
}

//main function
int main(){
	pthread_t td1;
	pthread_t td2;
	
	sem_init(&mutex, 0, 0);
	
	pthread_create(&td1, NULL, thread_hi_nosem, NULL);
	pthread_create(&td2, NULL, thread_Daljeet_nosem, NULL);
	
	pthread_join(td1, NULL);
	pthread_join(td2, NULL);
	
	sem_destroy(&mutex);
	
	return 0;
}
