//��׺���ʽת��Ϊ��׺���ʽ
#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#define STACK_INIT_SIZE 20
#define STACKINCRMENT 5
typedef char SElemtype;
typedef struct {
	SElemtype *base;
	SElemtype *top;
	int stacksize;
}L,*SqStack;
//����ջ
int InitStack(SqStack S) {
	S->base = (SElemtype *)malloc(20 * sizeof(SElemtype));   //����malloc���������䴢��ռ�
	if (!S->base) {               //S->baseΪ�գ�����ռ�ʧ�ܣ�������ʾ
		printf("�洢����ʧ��");
	}
	S->top = S->base;      //ջ��ָ��ָ��ջ��
	S->stacksize = STACK_INIT_SIZE;   //��ʼ��С
	return 0;
}
//��ջ�ĳ���
int StackLength(SqStack S) {
	return (S->top - S->base);
}
void Push(SqStack S, char e) {
	if (S->top - S->base >= S->stacksize) {     
		S->base = (SElemtype *)realloc(S->base, (S->stacksize + 10) * sizeof(SElemtype));  
		if (!S->base) exit(1);      
		S->top = S->base + S->stacksize; 
		S->stacksize += STACKINCRMENT; 
	}
	*(S->top++) = e;  //����ֵ
}
void Pop(SqStack S, char *e)
{
	if (S->top == S->base)
		printf("ջΪ��");
	*e =*--S->top;
}
//��׺���ʽת��Ϊ��׺���ʽ
void turn(SqStack S, SElemtype str[]) {
	int i = 0; SElemtype p = 'y';
	while (str[i] != '\0') {
		while (isdigit(str[i])) {
			printf("%c", str[i++]);
			if (!isdigit(str[i]))
			{
				printf(" ");
			}
		}
		if (str[i] == '+' || str[i] == '-') {
			if (StackLength(S) == 0) {
				Push(S, str[i]);
			}
			else {
				do {
					Pop(S, &p);
					if (p == '(') {
						Push(S, p);
					}
					else printf("%c", p);
				} while (StackLength(S) && p != '(');
				Push(S, str[i]);  //��+-ѹ��
			}
		}
		else if (str[i] == ')') {
			/*while (p == '(') {
				Pop(S, p);
				printf("%c", p);
			}*/  //����ԭ��p��ֵ���Ͳ���'(',ֱ���˳��������ʽ���£�
			Pop(S, &p);
			while (p != '(') {
				printf("%c", p);
				Pop(S, &p);
			}
		}
		else if (str[i] == '*' || str[i] == '/' || str[i] == '(') {
			Push(S, str[i]);
		}
		else if (str[i] == '\0')
		{
			break;
		}
		else
		{
			printf("\n�����ʽ����\n");
			return;
		}
		i++;
	}
	while (StackLength(S)) {
		Pop(S, &p);
		printf("%c", p);
	}
}
int main() {
	int i; SElemtype str[STACK_INIT_SIZE];
	SqStack A;
	A = (SqStack)malloc(sizeof(L));
	InitStack(A);
	printf("��������׺���ʽ��");
	gets_s(str);
	turn(A, str);
	system("pause");
	return 0;
}