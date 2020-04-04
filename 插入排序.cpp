//插入排序 
#include<stdio.h>
#include<stdlib.h>
//升序
void Insertion(int sun[]) {
	int i, j, pass;
	for (i = 1; i < 10; i++) {
		j = i - 1;
		pass = sun[i];      //将索引为i的元素数据保留
		while (j >= 0 && sun[j] > pass) {  //循环条件，变化索引不越界，变化指向大于i，向后退,由于已保留数据，前一元素直接覆盖本元素
			sun[j + 1] = sun[j];
			j--;
		}
		sun[j + 1] = pass;  //插入合适位置
	}
}
int main() {
	int sun[10], i;
	printf("请输入十个数字：");
	for (i = 0; i < 10; i++) {
		scanf_s("%d", &sun[i]);
	}
	Insertion(sun);
	printf("排序后数组：");
	for (i = 0; i < 10; i++) {
		printf(" %d", sun[i]);
	}
	system("pause");
	return 0;
}
/*
思想：i,j i指向第二个元素(从第二个元素开始），i指向数据保存到pass中，
j做变化元素，递减，i指向元素与j指向元素相比，如果j指向元素大于i指向
元素，j直接覆盖j+1元素（以“递归”保存）；若小于，则插入比较元素后（j+1)
而后i++，继续比较后续元素
（挺棒的思想，但时间复杂度仍未减少，但又是希尔排序的关键）
*/