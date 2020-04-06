//快速排序，有遗憾，key不是随机生成
#include<stdio.h>
#include<stdlib.h>

int partition(int sun[], int left, int right) {
	int povit = sun[left];      //将key记录在变量中
	while (left < right) {
		while (left < right&&sun[right] >= povit) --right;   //从右开始，依次比较，找到比key小的，移到左侧
		sun[left] = sun[right];        //key比较特殊，找到直接覆盖
		while (left < right&&sun[left] <= povit)   ++left;
		sun[right] = sun[left];     //找到直接放在右边的空位上
	}
	sun[left] = povit;   //找到key的最终位置，记录
	return left;        //返回key最终位置，用于区分
}

void sort(int sun[],int left,int right) {
	if (left < right) {
		int pivot2 = partition(sun, left, right);  
		sort(sun, left, pivot2 - 1);    //跳过确定的key
		sort(sun, pivot2 + 1, right);
	}
}
		
int main() {
	int a[6];
	printf("输入10个数字：");
	for (int i = 0; i < 6; i++) {
		scanf_s("%d", &a[i]);
	}
	printf("你的结果：");
	sort(a,0,5);
	for (int i = 0; i < 6; i++) {
		printf(" %d", a[i]);
	}
	system("pause");
	return 0;
}