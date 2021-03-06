#include<stdio.h>
#include<stdlib.h>
struct Node {
	int data;
	struct Node* next;
};
void CreateList(struct Node* L, int n)
{
	int i;
	struct Node* p;
        for(i=0;i<n;i++){
	 	p = (struct Node*)malloc(sizeof(struct Node));
		scanf("%d", &p->data);
		p->next = L->next; L->next = p;
	}
	return;
	
}
void printfList(struct Node* headNode)
{
	struct Node* use = headNode->next;
	while (use) {
		printf("%d\t", use->data);
		use = use->next;
	}
}
void sortList(struct Node* headNode1, struct Node* headNode2, struct Node* headNode3)
{
	struct Node* point1=headNode1->next; 
        struct Node* point2=headNode2->next; 
        struct Node* point3=headNode1;
	while (point1&&point2) {
		if (point1->data >= point2->data)
		{
			point3->next = point2; point3 = point2; point2 = point2->next;
		}
		else { point3->next = point1; point3 = point1; point1 = point1->next; }
	}
	point3->next = point1 ? point1 : point2;
}
int main()
{
	struct Node* point1; struct Node* point2; struct Node* point3;
	int n, n2, i;
	printf("请输入你想创建的第一个数组的长度：");
	scanf("%d", &n);
	printf("请输入你想创建的第二个数组的长度：");
	scanf("%d", &n2);
	point1 = (struct Node*)malloc(sizeof(struct Node));
	point1->next = NULL;
	point2 = (struct Node*)malloc(sizeof(struct Node));
	point2->next = NULL;
	point3 = (struct Node*)malloc(sizeof(struct Node));
	point3->next = NULL;
	point3 = point1;
	printf("输入第一组数据：");
	CreateList(point1, n);
	printf("输入第二组数据：");
	CreateList(point2, n2);
	printf("你输入的第一个数组：");
	printfList(point1);
	printf("你输入的第二个数组：");
	printfList(point2);
	printf("\n");
	sortList(point1, point2, point3);
	printf("归并之后的结果：");
	printfList(point3);
	free(point1);
	free(point2);
	free(point3);
	system("pause");
	return 0;
}