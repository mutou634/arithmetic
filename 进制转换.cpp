#include<stdio.h>
#include<stdlib.h>
#define STACK_INIT_SIZE 100;    //�궨�� ��STACK_INIT_SIZE����ʾ100����ͬ��
#define STACKINCERMENT 10;
typedef struct {
	int *base;  //ջ��ָ�룬��ջ����֮ǰ������֮��ֵΪ��NULL
	int *top;   //ջ��ָ��
	int stacksize;   //��ǰ�ѷ���Ĵ���ռ䣬��ʹ�õ����ʹ�СΪ��λ
}L,*SqStack;         //typedef struct L,*SqStack.����֮�����L������ṹ���������SqStack������ṹ�����
int InitStack(SqStack S) {       //�����µ�ջ
	S->base = (int *)malloc(100 * sizeof(int));   //����malloc���������䴢��ռ�
	if (!S->base) {               //S->baseΪ�գ�����ռ�ʧ�ܣ�������ʾ
		printf("�洢����ʧ��");
	}
	S->top = S->base;      //ջ��ָ��ָ��ջ��
	S->stacksize = STACK_INIT_SIZE;   //��ʼ��С
	return 0;
}
void Push(SqStack S, int e) {         //ѹջ����
	if (S->top - S->base >= S->stacksize) {     //������Ԫ��ǰ�ж�ջ�Ƿ�Ϊ������ֹջ�����
		S->base = (int *)realloc(S->base, (S->stacksize + 10) * sizeof(int));  //���ջ����������realloc�������·���ռ䣬������һ��ָ��ָ����ڴ������ֵ���Ƶ��µ��ڴ�����;
		if (!S->base) exit(1);      //����洢ʧ�����˳�����
		S->top = S->base + S->stacksize;  //����ջ��ָ���ָ��
		S->stacksize += STACKINCERMENT;   //����ռ�����
	}
	*(S->top++) = e;  //����ֵ
}
int StackEmpty(SqStack S) {    //�ж�ջ�Ƿ�Ϊ�յĺ����� ���շ���1
	if (S->top == S->base) return 1;
	else return 0;

}
void Pop(SqStack S, int *e)    //��ջ����
{
	if (S->top == S->base) 
		printf("ջΪ��");
	*e = *--S->top;  //��ջ��Ԫ��ֵ����e,����ջ��ָ��ǰһ��Ԫ��
}
void conversion(SqStack S) {    //����ת������
	int e=0;
	int N;
	printf("������Ǹ�ʮ����������");
	scanf_s("%d", &N);
	printf("%d(10)=", N);
	//���ý���ת��ԭ������ѹ��ջ�У���ʵ�����
	while (N) {           
		Push(S, N % 8);     
		N = N / 8;
	}
	while (!StackEmpty(S)) {  //ջ��Ԫ�����������ֹͣѭ��
		Pop(S, &e);
		printf("%d", e);
	}
	printf("(8)");
} 
int main()     //������ʵ�ֺ����ĵ���
{
	SqStack point;
	point = (SqStack)malloc(sizeof(L));
	InitStack(point);
	conversion(point);
	free(point);
	system("pause");
	return 0;
}