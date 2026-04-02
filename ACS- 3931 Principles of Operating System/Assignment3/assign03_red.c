/*
Name: Daljeet Singh
Student ID: 3169763
Assignment: 3
Part I
*/

#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>

int main (int argc, char *argv[]) {
	int fd;
	
	if (argc < 2) {
		printf ("Error: no filename passed\n");
		return 1;
	}
	
	fd = open (argv[1], O_WRONLY | O_CREAT | O_TRUNC, 0644);
	if (fd == -1) {
		perror ("open");
		return 1;
	}
	
	if (dup2 (fd, STDOUT_FILENO) == -1) {
		perror("dup2");
		close(fd);
		return 1;
	}
	
	close (fd);
	
	printf ("Hello Daljeet Singh, I'm being redirected to a file instead of the I/O display device!\n");
	fflush(stdout);
	
	return 0;
}
