//�������� 
#include<stdio.h>
#include<stdlib.h>
//����
void Insertion(int sun[]) {
	int i, j, pass;
	for (i = 1; i < 10; i++) {
		j = i - 1;
		pass = sun[i];      //������Ϊi��Ԫ�����ݱ���
		while (j >= 0 && sun[j] > pass) {  //ѭ���������仯������Խ�磬�仯ָ�����i�������,�����ѱ������ݣ�ǰһԪ��ֱ�Ӹ��Ǳ�Ԫ��
			sun[j + 1] = sun[j];
			j--;
		}
		sun[j + 1] = pass;  //�������λ��
	}
}
int main() {
	int sun[10], i;
	printf("������ʮ�����֣�");
	for (i = 0; i < 10; i++) {
		scanf_s("%d", &sun[i]);
	}
	Insertion(sun);
	printf("��������飺");
	for (i = 0; i < 10; i++) {
		printf(" %d", sun[i]);
	}
	system("pause");
	return 0;
}
/*
˼�룺i,j iָ��ڶ���Ԫ��(�ӵڶ���Ԫ�ؿ�ʼ����iָ�����ݱ��浽pass�У�
j���仯Ԫ�أ��ݼ���iָ��Ԫ����jָ��Ԫ����ȣ����jָ��Ԫ�ش���iָ��
Ԫ�أ�jֱ�Ӹ���j+1Ԫ�أ��ԡ��ݹ顱���棩����С�ڣ������Ƚ�Ԫ�غ�j+1)
����i++�������ȽϺ���Ԫ��
��ͦ����˼�룬��ʱ�临�Ӷ���δ���٣�������ϣ������Ĺؼ���
*/