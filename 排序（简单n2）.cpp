#include<stdio.h>
//Ã°ÅÝÅÅÐò
void sort(int sun[]) {  //ÉýÐò
	int i, j, pass;
	for (i = 9; i >= 0; i--) {
		for (j = i - 1; j >= 0; j--) {
			if (sun[i] < sun[j]) {
				pass = sun[j];
				sun[j] = sun[i];
				sun[i] = pass;
			}
		}
	}
}
//Ñ¡ÔñÅÅÐò
void sort(int sun[]) {
	int i,j,min,pass;
	for (i = 0; i < 9; i++) {
		min = i;
		for (j = i + 1; j < 10; j++) {
			if (sun[j] < sun[min]) {
				min = j;
			}
		}
		pass = sun[i];
		sun[i] = sun[min];
		sun[min] = pass;
	}
}
int main() {
	int sun[10], i;
	printf("ÊäÈëÊ®¸öÊý×Ö£º");
	for (i = 0; i < 10; i++) {
		scanf_s("%d", &sun[i]);
	}
	sort(sun);
	for (i = 0; i < 10; i++) {
		printf(" %d", sun[i]);
	}
	system("pause");
	return 0;
}