#include<stdio.h>
#include<stdlib.h>
typedef char TElemType;
typedef struct BiTNode {
	TElemType data;
	struct BiTNode *lchild, *rchild;
}BiTNode, *BiTree;      //定义二叉树结点，其中包括指向左右孩子的指针
void CreateBiTree(BiTree &T)      //创建一个二叉树，用先序顺序输入
{
	char e;
	scanf_s("%c", &e);
	if (e == ' ') T = NULL;   //用空格代表无左或右孩子
	else {
		if (!(T = (BiTNode *)malloc(sizeof(BiTNode)))) exit(0);  //不为空则申请一个内存空间
		T->data = e;
		CreateBiTree(T->lchild);        //用递归的方法创建
		CreateBiTree(T->rchild);
	}
}
void visit(char e, int level) {
	printf("%c位于第%d层\n", e, level);
}
void visit1(char e) {
	printf("%c", e);
}
int OrderTraverse(BiTree &T, int level)     //输出二叉树结点所在层数，用level记录
{
	if (T) {
		visit(T->data, level);
		OrderTraverse(T->lchild, level + 1);
		OrderTraverse(T->rchild, level + 1);
	}
	return 1;
}
int PreOrderTraverse(BiTree &T)      //先序输出函数，递归调用自身
{
	if (T) {
		visit1(T->data);                   //先输出根结点
		PreOrderTraverse(T->lchild);       //先序遍历左孩子
		PreOrderTraverse(T->rchild);       //先序遍历有孩子
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
int main() {  //主函数调用各个函数
	int level = 1;
	BiTree T = NULL;
	printf("请输入数据：");
	CreateBiTree(T);
	printf("二叉树的结点层数预览:\n");
	OrderTraverse(T, level);
	printf("前序遍历输出:");
	PreOrderTraverse(T);
	printf("\n中序遍历输出:");
	InOrderTraverse(T);
	printf("\n后序遍历输出:");
	BackOrderTraverse(T);
	system("pause");
	return 0;
}
