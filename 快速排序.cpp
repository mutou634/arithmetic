//�����������ź���key�����������
#include<stdio.h>
#include<stdlib.h>

int partition(int sun[], int left, int right) {
	int povit = sun[left];      //��key��¼�ڱ�����
	while (left < right) {
		while (left < right&&sun[right] >= povit) --right;   //���ҿ�ʼ�����αȽϣ��ҵ���keyС�ģ��Ƶ����
		sun[left] = sun[right];        //key�Ƚ����⣬�ҵ�ֱ�Ӹ���
		while (left < right&&sun[left] <= povit)   ++left;
		sun[right] = sun[left];     //�ҵ�ֱ�ӷ����ұߵĿ�λ��
	}
	sun[left] = povit;   //�ҵ�key������λ�ã���¼
	return left;        //����key����λ�ã���������
}

void sort(int sun[],int left,int right) {
	if (left < right) {
		int pivot2 = partition(sun, left, right);  
		sort(sun, left, pivot2 - 1);    //����ȷ����key
		sort(sun, pivot2 + 1, right);
	}
}
		
int main() {
	int a[6];
	printf("����10�����֣�");
	for (int i = 0; i < 6; i++) {
		scanf_s("%d", &a[i]);
	}
	printf("��Ľ����");
	sort(a,0,5);
	for (int i = 0; i < 6; i++) {
		printf(" %d", a[i]);
	}
	system("pause");
	return 0;
}