#include<stdio.h>
#include<stdlib.h>
typedef char TElemType;
typedef struct BiTNode {
	TElemType data;
	struct BiTNode *lchild, *rchild;
}BiTNode, *BiTree;      //�����������㣬���а���ָ�����Һ��ӵ�ָ��
void CreateBiTree(BiTree &T)      //����һ����������������˳������
{
	char e;
	scanf_s("%c", &e);
	if (e == ' ') T = NULL;   //�ÿո����������Һ���
	else {
		if (!(T = (BiTNode *)malloc(sizeof(BiTNode)))) exit(0);  //��Ϊ��������һ���ڴ�ռ�
		T->data = e;
		CreateBiTree(T->lchild);        //�õݹ�ķ�������
		CreateBiTree(T->rchild);
	}
}
void visit(char e, int level) {
	printf("%cλ�ڵ�%d��\n", e, level);
}
void visit1(char e) {
	printf("%c", e);
}
int OrderTraverse(BiTree &T, int level)     //���������������ڲ�������level��¼
{
	if (T) {
		visit(T->data, level);
		OrderTraverse(T->lchild, level + 1);
		OrderTraverse(T->rchild, level + 1);
	}
	return 1;
}
int PreOrderTraverse(BiTree &T)      //��������������ݹ��������
{
	if (T) {
		visit1(T->data);                   //����������
		PreOrderTraverse(T->lchild);       //�����������
		PreOrderTraverse(T->rchild);       //��������к���
	}
	return 1;
}
int InOrderTraverse(BiTree &T) {
	if (T) {
		InOrderTraverse(T->lchild);
		visit1(T->data);
		InOrderTraverse(T->rchild);
	}
	return 1;
}
int BackOrderTraverse(BiTree &T) {
	if (T) {
		BackOrderTraverse(T->lchild);
		BackOrderTraverse(T->rchild);
		visit1(T->data);
	}
	return 1;
}
int main() {  //���������ø�������
	int level = 1;
	BiTree T = NULL;
	printf("���������ݣ�");
	CreateBiTree(T);
	printf("�������Ľ�����Ԥ��:\n");
	OrderTraverse(T, level);
	printf("ǰ��������:");
	PreOrderTraverse(T);
	printf("\n����������:");
	InOrderTraverse(T);
	printf("\n����������:");
	BackOrderTraverse(T);
	system("pause");
	return 0;
}
