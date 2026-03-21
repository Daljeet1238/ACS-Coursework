// Daljeet Singh
// 3169763
// Part II

#include <stdio.h>
#include <pthread.h>

//thread1
void *thread_hi_nosem(void *arg){
	for (int i=0; i<200; i++){
		printf(".");
	}
	
	printf(" hi there\n");
	return NULL;
	
}

//thread2
void *thread_Daljeet_nosem(void *arg){
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
	
	pthread_create(&td1, NULL, thread_hi_nosem, NULL);
	pthread_create(&td2, NULL, thread_Daljeet_nosem, NULL);
	
	pthread_join(td1, NULL);
	pthread_join(td2, NULL);
	
	return 0;
}
