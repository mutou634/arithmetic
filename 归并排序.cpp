#include<stdio.h>
#include<stdlib.h>
//�鲢����
//������������������鲢
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
	while (i <= m)     //�ݴ�����ʱ����
		temp[k++] = a[i++];
	while (j <= n)
		temp[k++] = a[j++];
	for (i = 0; i < k; i++)  //�����鸴�ƽ���ԭ����
		a[first + i] = temp[i];
}
//mid������Ҫ
void mergesort(int a[], int first, int last, int temp[]) { //���С��֡������õݹ����
	if (first < last) {
		int mid = (first + last) / 2;
		mergesort(a, first, mid, temp);       //�󵱵�����Ϊ���ң���Ϊ��һֹͣ
		mergesort(a, mid + 1, last, temp);    //���ҵ���ʱ���ٷ�Ϊ���ң�midΪ����ġ�mid��
		mergearray(a, first, mid, last, temp);   //midΪ��һmid��1
	}
}
int main() {
	int a[10];
	int temp[10];
	int n;
	printf("����10�����֣�");
	for (int i = 0; i < 10; i++) {
		scanf_s("%d", &a[i]);
	}
	printf("��Ľ����");
	mergesort(a, 0, 9, temp);
	for (int i = 0; i < 10; i++) {
		printf(" %d", a[i]);
	}
	system("pause");
	return 0;
}