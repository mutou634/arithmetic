//�����沨�����ʽ���ļ����������õ���������ͬ���͵�ջ���ظ�д������ջ������ϣ���Ժ����������Կ������ر����ظ�
#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#define STACK_INIT_SIZE 20
#define STACKINCRMENT 5
//����׺���ʽת��Ϊ��׺���ʽ
typedef char SElemtype;
typedef struct {
	SElemtype *base;
	SElemtype *top;
	int stacksize;
}L, *SqStack;
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
		S->base = (SElemtype *)realloc(S->base, (S->stacksize + 5) * sizeof(SElemtype));
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
	*e = *--S->top;
}
void turn(SqStack S, SElemtype str[], SElemtype str2[]) {
	InitStack(S);
	int i = 0, j = 0; SElemtype p = 'y';
	while (str[i] != '\0') {
		while (isdigit(str[i])||str[i]=='.') {
			str2[j++] = str[i];
			str2[j] = '\0';
			printf("%c", str[i++]);
			if (!isdigit(str[i])&&str[i]!='.')
			{
				str2[j++] = ' ';       //���һ��Ԫ��Ϊ�ո�
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
					else {
						str2[j++] = p;
						str2[j] = '\0';
						printf("%c", p);
					}
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
				str2[j++] = p;
				str2[j] = '\0';
				Pop(S, &p);
			}
		}
		else if (str[i] == '*' || str[i] == '/' || str[i] == '(') {
			Push(S, str[i]);
		}
		else if (str[i] == '\0') {    //���һ�����ֵĽ�β
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
		str2[j++] = p;
		str2[j] = '\0';
		printf("%c", p);
	}
}


//����
typedef double SElemtype1;
typedef struct {
	SElemtype1 *base;
	SElemtype1 *top;
	int stacksize;
}L1, *SqStack1;
//����ջ
int InitStack(SqStack1 S) {
	S->base = (SElemtype1 *)malloc(20 * sizeof(SElemtype1));   //����malloc���������䴢��ռ�
	if (!S->base) {               //S->baseΪ�գ�����ռ�ʧ�ܣ�������ʾ
		printf("�洢����ʧ��");
	}
	S->top = S->base;      //ջ��ָ��ָ��ջ��
	S->stacksize = STACK_INIT_SIZE;   //��ʼ��С
	return 0;
}
//��ջ�ĳ���
int StackLength(SqStack1 S) {
	return (S->top - S->base);
}
void Push(SqStack1 S, double e) {
	if (S->top - S->base >= S->stacksize) {
		S->base = (SElemtype1 *)realloc(S->base, (S->stacksize + 5) * sizeof(SElemtype1));
		if (!S->base) exit(1);
		S->top = S->base + S->stacksize;
		S->stacksize += STACKINCRMENT;
	}
	*(S->top++) = e;  //����ֵ
}
void Pop(SqStack1 S, double *e)
{
	if (S->top == S->base)
		printf("ջΪ��");
	*e = *--S->top;
}
void count(SqStack1 S, char str[]) {
	SElemtype1 number, e, d;
	char arr[STACK_INIT_SIZE];
	int i = 0, j = 0;
	while (str[i] != '\0') {
		while (isdigit(str[i]) || str[i] == '.') {   //�ַ���ֵװ��Ϊdouble��
			arr[j++] = str[i++];
			arr[j] = '\0';
			if (str[i] == ' ') {     //��1��i++ϣ�����Լ���ѭ������ (2)���������һ������ʱ��i+1��ֵΪ�գ�����Խ�硣
				number = atof(arr);    
				Push(S, number);
				j = 0;
				break;
			}
		}
		switch (str[i]) {
		case '+':
			Pop(S, &e);
			Pop(S, &d);
			Push(S, e + d);
			break;
		case '-':
			Pop(S, &e);
			Pop(S, &d);
			Push(S, e - d);
			break;
		case '/':
			Pop(S, &e);
			Pop(S, &d);
			Push(S, e / d);
			break;
		case '*':
			Pop(S, &e);
			Pop(S, &d);
			Push(S, e * d);
			break;
		}
		i++;
	}
	Pop(S, &e);
	printf("������Ϊ��%lf", e);
}
int main() {
	int i = 0,j=0; char str[STACK_INIT_SIZE];
	char str2[STACK_INIT_SIZE];
	SqStack A; SqStack1 S;
	A = (SqStack)malloc(sizeof(L));
	S = (SqStack1)malloc(sizeof(L1));
	InitStack(A);
	InitStack(S);
	printf("��������׺���ʽ��");
	gets_s(str);
	turn(A, str,str2);
	printf("\n");
	count(S, str2);
	system("pause");
	return 0;
}
/*
����������gets_s():stdio.hͷ�ļ����������ܣ������뻺�����ж�ȡһ���ַ����洢���ַ�ָ����� str ��ָ����ڴ�ռ䡣Ҳ���Դ�ո�
isdigit():������ctypeͷ�ļ��У����ܣ��������Ƿ�Ϊʮ���������ַ���
*/