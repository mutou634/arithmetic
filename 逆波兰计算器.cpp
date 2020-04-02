//利用逆波兰表达式做的计算器，但用到的两个不同类型的栈，重复写了两个栈函数，希望以后用其他语言可以重载避免重复
#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#define STACK_INIT_SIZE 20
#define STACKINCRMENT 5
//将中缀表达式转换为后缀表达式
typedef char SElemtype;
typedef struct {
	SElemtype *base;
	SElemtype *top;
	int stacksize;
}L, *SqStack;
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
		S->base = (SElemtype *)realloc(S->base, (S->stacksize + 5) * sizeof(SElemtype));
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
				str2[j++] = ' ';       //最后一个元素为空格
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
				str2[j++] = p;
				str2[j] = '\0';
				Pop(S, &p);
			}
		}
		else if (str[i] == '*' || str[i] == '/' || str[i] == '(') {
			Push(S, str[i]);
		}
		else if (str[i] == '\0') {    //最后一个数字的结尾
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
		str2[j++] = p;
		str2[j] = '\0';
		printf("%c", p);
	}
}


//计算
typedef double SElemtype1;
typedef struct {
	SElemtype1 *base;
	SElemtype1 *top;
	int stacksize;
}L1, *SqStack1;
//构造栈
int InitStack(SqStack1 S) {
	S->base = (SElemtype1 *)malloc(20 * sizeof(SElemtype1));   //利用malloc函数来分配储存空间
	if (!S->base) {               //S->base为空，分配空间失败，发出提示
		printf("存储分配失败");
	}
	S->top = S->base;      //栈顶指针指向栈底
	S->stacksize = STACK_INIT_SIZE;   //起始大小
	return 0;
}
//求栈的长度
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
	*(S->top++) = e;  //存入值
}
void Pop(SqStack1 S, double *e)
{
	if (S->top == S->base)
		printf("栈为空");
	*e = *--S->top;
}
void count(SqStack1 S, char str[]) {
	SElemtype1 number, e, d;
	char arr[STACK_INIT_SIZE];
	int i = 0, j = 0;
	while (str[i] != '\0') {
		while (isdigit(str[i]) || str[i] == '.') {   //字符数值装换为double型
			arr[j++] = str[i++];
			arr[j] = '\0';
			if (str[i] == ' ') {     //（1）i++希望可以减少循环次数 (2)当输入最后一个数字时，i+1数值为空，数组越界。
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
	printf("计算结果为：%lf", e);
}
int main() {
	int i = 0,j=0; char str[STACK_INIT_SIZE];
	char str2[STACK_INIT_SIZE];
	SqStack A; SqStack1 S;
	A = (SqStack)malloc(sizeof(L));
	S = (SqStack1)malloc(sizeof(L1));
	InitStack(A);
	InitStack(S);
	printf("请输入中缀表达式：");
	gets_s(str);
	turn(A, str,str2);
	printf("\n");
	count(S, str2);
	system("pause");
	return 0;
}
/*
新增函数：gets_s():stdio.h头文件包含，功能：从输入缓冲区中读取一个字符串存储到字符指针变量 str 所指向的内存空间。也可以存空格。
isdigit():包含在ctype头文件中，功能：检查参数是否为十进制数字字符。
*/