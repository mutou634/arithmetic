struct Node {
	Node() {
		value = 0;
		weight = 0;
		level = 0;
		parent = 0;
		bound = 0;
	}
	int value;           //�������ýڵ�ʱ�ļ�ֵ
	int weight;          //�������ýڵ�ʱ��������
	float bound;		 //�����Ըýڵ�Ϊ���������ܴﵽ�ļ�ֵ�Ͻ�
	int level;           //�ýڵ�������Σ���0��ʼ
	struct  Node *parent;//ָ�򸸽ڵ�
};
 
struct cmp {
	bool operator () (Node *a, Node *b) {
		return a->bound < b->bound;
	}
};
 
struct Item{
	int ItemID;			//��Ʒ���
	int value;			//��Ʒ��ֵ
	int weight;			//��Ʒ����
	float ratio;		//��ֵ/����
};
 
bool ItemCmp(Item item1, Item item2) {
	return item1.ratio > item2.ratio;
}
 
#include <iostream>
#include <queue>
#include "Structure.h"
#include <algorithm>
#define N 10               //��Ʒ��ΪN
using namespace std;
int branchAndBound(Item items[], int c);
float maxBound(Node *node, Item items[], int c);
 
int maxSize=0;
int searchCount=0;
int main() {
	//int v[N] = {40,25, 25 };//��Ʒ��ֵ
	//int w[N] = {20,15, 15 };//��Ʒ����
	//int w[N] = {2,7,3,4,8,5,8,6,4,16};
	//int v[N] = {15,25,8,9,15,9,13,9,6,14};
	int w[N] = {2,8,4,4,8,7,8,5,16,16};
	int v[N] = {15,25,9,9,15,12,12,6,14,9 };
	int c = 34;			    //��������
	Item items[N];
	int maxVlue;
 
	for (int i = 0; i < N; i++) {
		items[i].ItemID = i;
		items[i].value = v[i];
		items[i].weight = w[i];
		items[i].ratio = (float)v[i] / w[i];
	}
	sort(items,items+N,ItemCmp);//����ֵ������
	
	cout << "��Ʒ��ֵ����Ϊ��"<<endl;
	for (int i = 0; i < N; i++) {
		cout << v[i] << " ";
	}
	cout << endl;
	cout << "��Ʒ��������Ϊ��" << endl;
	for (int i = 0; i < N; i++) {
		cout << w[i] << " ";
	}
	cout << endl;
	cout << "ѡȡ����Ϊ:(1Ϊȡ)" << endl;
	maxVlue = branchAndBound(items, c);
	cout << "����ֵΪ:" << maxVlue << endl;
	cout << "������Ԫ�����Ϊ��" << maxSize << endl;
	cout << "��������Ϊ��" << searchCount << "" << endl;
	return 0;
}
 
int branchAndBound(Item items[], int c) {
	int x[N] = { 0 };
	int maxValue;			                              //���浱ǰ������������ֵ
	Node *maxNode = new Node();                           //���浱ǰ����ֵ�ڵ㣨Ҷ�ڵ㣩
	priority_queue<Node *, vector<Node *>, cmp> maxQueue; //����ֵ���ȶ���
	Node *firstNode, *curNode;
 
	searchCount = 1;
	firstNode = new Node();
	firstNode->bound = maxBound(firstNode,items,c);
	firstNode->parent = NULL;
	maxQueue.push(firstNode);							      //��ӵ�һ�����
	maxValue = 0;
	maxNode = firstNode;
	while (!maxQueue.empty())
	{
		curNode = maxQueue.top(); maxQueue.pop();
		//��չ���ӽ��
		if (curNode->weight + items[curNode->level].weight <= c) {	//��������޽�
			Node *leftNode = new Node();
			leftNode->value = curNode->value + items[curNode->level].value;
			leftNode->weight = curNode->weight + items[curNode->level].weight;
			leftNode->level = curNode->level + 1;
			leftNode->parent = curNode;
			leftNode->bound = curNode->bound;
			if (leftNode->level<N) {
				maxQueue.push(leftNode);
				searchCount++;
			}
			if (maxValue < leftNode->value) {
				maxValue = leftNode->value;
				maxNode = leftNode;
			}
		}
		//��չ�Һ��ӽ��
		if (maxBound(curNode, items, c)>maxValue) {					//����ֵ�Ͻ��޽�
			Node *rightNode = new Node();
			rightNode->value = curNode->value;
			rightNode->weight = curNode->weight;
			rightNode->level = curNode->level + 1;
			rightNode->parent = curNode;
			rightNode->bound = maxBound(rightNode,items,c);
			if (rightNode->level < N) {
				maxQueue.push(rightNode);
				searchCount++;
			}
		}
		//���ٶ��д�С
		if (maxQueue.size()>maxSize)
			maxSize = maxQueue.size();
	}
	curNode = maxNode;
	while (curNode) {
		int tempValue = curNode->value;
		curNode = curNode->parent;
		if (curNode && curNode->value != tempValue)
			x[items[curNode->level].ItemID] = 1;
	}
	for (int i = 0; i < N; i++) {
		cout << x[i] << " ";
	}
	cout << endl;
	return maxValue;
}
//�޽纯��
float maxBound(Node *node, Item items[], int c) {			//���Ըýڵ�Ϊ���������ܴﵽ�ļ�ֵ�Ͻ�
	float maxValue;
	int restCapacity;				//��չ���ýڵ�ʱ��ʣ������
	int i;
 
	maxValue = node->value;
	restCapacity = c - node->weight;
	i = node->level;
	while (i<N && restCapacity>items[i].weight) {
		maxValue += items[i].value;
		restCapacity -= items[i].weight;
		i++;
	}
	if (restCapacity != 0) {
		maxValue += restCapacity*items[i].ratio;
	}
	return maxValue;
}