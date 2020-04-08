//�շ���������
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
typedef struct {
    int weight;
	int parent, lchild, rchild;
}HTNode,*HuffmanTree;
typedef char** HuffmanCode;

void select(HuffmanTree ht, int n, int *s1, int *s2)  //��Ȩֵ��С���������
{
	int i;
	int minn=999;
	for (i = 1; i <= n; i++)
	{
		if (ht[i].parent == 0 && ht[i].weight < minn)
		{
			minn = ht[i].weight;
			*s1 = i;
		}
	}
	minn =999;
	for (i = 1; i <= n; i++)
	{
		if (ht[i].parent == 0 && ht[i].weight < minn && *s1 != i)  //�������������Сֵ���ҵڶ�Сֵ
		{
			minn = ht[i].weight;
			*s2 = i;
		}
	}
}

void HuffmanCoding(HuffmanTree HT, HuffmanCode HC, int w[], int n) {
	int m,i,s1,s2;
	if (n <= 1) return;
	m = 2 * n - 1;
	HT = (HuffmanTree)malloc((m+1) * sizeof(HTNode));
	for (i = 1; i <= n; i++) {      //��ʼ���������Ĵ洢��++p��"n"��ͣ����
		HT[i].weight = w[i];
		HT[i].lchild = 0; HT[i].rchild = 0; HT[i].parent = 0;
	}
	for (; i <= m; i++) {
		HT[i].weight = 0; HT[i].rchild = 0; HT[i].lchild = 0; HT[i].parent = 0;
	}
	for (i = n + 1; i <= m; ++i) {                        //�����շ�����
		select(HT, i - 1, &s1, &s2);  //s1,s2�൱������
		HT[s1].parent = i;  HT[s2].parent = i;
		HT[i].lchild = s1;  HT[i].rchild = s2;
		HT[i].weight = HT[s1].weight + HT[s2].weight;
	}
	for (i = 1; i <= m; i++) {
		printf("%d %d %d %d\n", HT[i].weight, HT[i].parent, HT[i].lchild, HT[i]. rchild);
	}
	HC = (HuffmanCode)malloc((n + 1) * sizeof(char*));  //���ָ�루��ַ���Ķ�̬����
	char *cd = (char*)malloc(n * sizeof(char));
	cd[n - 1] = '\0';    int f;
	//2020.4.8��Ϊ���Ĳ���
	for (i = 1; i <= n; ++i) {
		int start = n - 1;   //�Ӻ�ʼ�洢
		for (int c = i, f = HT[i].parent; f != 0; c = f, f = HT[f].parent) 
			if (HT[f].lchild == c) cd[--start] = '0';
			else cd[--start] = '1';
		/*int c = i;   //Ҳ��
		int j = HT[i].parent;
		while (j != 0) {
			if (HT[j].lchild == c)
				cd[--start] = '0';
			else cd[--start] = '1';
			c = j; j = HT[j].parent;
		}*/
		HC[i] = (char*)malloc((n - start) * sizeof(char));
		strcpy_s(HC[i],n-start+1, &cd[start]);
		printf("%d=%s\n", i,HC[i]);
	}
	free(cd);
}
int main() {
	HuffmanTree BT=NULL;
	HuffmanCode BC=NULL;
	int w[9] = { 0 };
	for (int i = 1; i < 9; i++) {
		scanf_s("%d", &w[i]);
	}
	HuffmanCoding(BT, BC, w, 8);
	system("pause");
	return 0;
}
