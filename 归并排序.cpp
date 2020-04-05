#include<stdio.h>
#include<stdlib.h>
//归并排序
//将两个有序数组有序归并
void mergearray(int a[], int first, int mid, int last, int temp[]) {
	int i = first, j = mid + 1;
	int m = mid, n = last;
	int k = 0;
	while (i <= m && j <= n) {
		if (a[i] < a[j])
			temp[k++] = a[i++];
		else
			temp[k++] = a[j++];
	}
	while (i <= m)     //暂存入临时数组
		temp[k++] = a[i++];
	while (j <= n)
		temp[k++] = a[j++];
	for (i = 0; i < k; i++)  //将数组复制进入原数组
		a[first + i] = temp[i];
}
//mid至关重要
void mergesort(int a[], int first, int last, int temp[]) { //进行”分“，利用递归而分
	if (first < last) {
		int mid = (first + last) / 2;
		mergesort(a, first, mid, temp);       //左当道，分为左右，分为单一停止
		mergesort(a, mid + 1, last, temp);    //当右当道时，再分为左右，mid为最近的“mid”
		mergearray(a, first, mid, last, temp);   //mid为上一mid加1
	}
}
int main() {
	int a[10];
	int temp[10];
	int n;
	printf("输入10个数字：");
	for (int i = 0; i < 10; i++) {
		scanf_s("%d", &a[i]);
	}
	printf("你的结果：");
	mergesort(a, 0, 9, temp);
	for (int i = 0; i < 10; i++) {
		printf(" %d", a[i]);
	}
	system("pause");
	return 0;
}