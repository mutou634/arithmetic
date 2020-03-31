//中缀表达式转换为后缀表达式
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
//构造栈
int InitStack(SqStack S) {
	S->base = (SElemtype *)malloc(20 * sizeof(SElemtype));   //利用malloc函数来分配储存空间
	if (!S->base) {               //S->base为空，分配空间失败，发出提示
		printf("存储分配失败");
	}
	S->top = S->base;      //栈顶指针指向栈底
	S->stacksize = STACK_INIT_SIZE;   //起始大小
	return 0;
}
//求栈的长度
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
	*(S->top++) = e;  //存入值
}
void Pop(SqStack S, char *e)
{
	if (S->top == S->base)
		printf("栈为空");
	*e =*--S->top;
}
//中缀表达式转换为后缀表达式
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
				Push(S, str[i]);  //将+-压入
			}
		}
		else if (str[i] == ')') {
			/*while (p == '(') {
				Pop(S, p);
				printf("%c", p);
			}*/  //错误原因：p的值本就不是'(',直接退出，解决方式如下：
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
			printf("\n输入格式错误！\n");
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
	printf("请输入中缀表达式：");
	gets_s(str);
	turn(A, str);
	system("pause");
	return 0;
}