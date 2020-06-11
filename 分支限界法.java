struct Node {
	Node() {
		value = 0;
		weight = 0;
		level = 0;
		parent = 0;
		bound = 0;
	}
	int value;           //搜索到该节点时的价值
	int weight;          //搜索到该节点时的总重量
	float bound;		 //搜索以该节点为根的子树能达到的价值上界
	int level;           //该节点所处层次，从0开始
	struct  Node *parent;//指向父节点
};
 
struct cmp {
	bool operator () (Node *a, Node *b) {
		return a->bound < b->bound;
	}
};
 
struct Item{
	int ItemID;			//物品编号
	int value;			//物品价值
	int weight;			//物品重量
	float ratio;		//价值/重量
};
 
bool ItemCmp(Item item1, Item item2) {
	return item1.ratio > item2.ratio;
}
 
#include <iostream>
#include <queue>
#include "Structure.h"
#include <algorithm>
#define N 10               //物品数为N
using namespace std;
int branchAndBound(Item items[], int c);
float maxBound(Node *node, Item items[], int c);
 
int maxSize=0;
int searchCount=0;
int main() {
	//int v[N] = {40,25, 25 };//物品价值
	//int w[N] = {20,15, 15 };//物品重量
	//int w[N] = {2,7,3,4,8,5,8,6,4,16};
	//int v[N] = {15,25,8,9,15,9,13,9,6,14};
	int w[N] = {2,8,4,4,8,7,8,5,16,16};
	int v[N] = {15,25,9,9,15,12,12,6,14,9 };
	int c = 34;			    //背包容量
	Item items[N];
	int maxVlue;
 
	for (int i = 0; i < N; i++) {
		items[i].ItemID = i;
		items[i].value = v[i];
		items[i].weight = w[i];
		items[i].ratio = (float)v[i] / w[i];
	}
	sort(items,items+N,ItemCmp);//按价值率排序
	
	cout << "商品价值依次为："<<endl;
	for (int i = 0; i < N; i++) {
		cout << v[i] << " ";
	}
	cout << endl;
	cout << "商品重量依次为：" << endl;
	for (int i = 0; i < N; i++) {
		cout << w[i] << " ";
	}
	cout << endl;
	cout << "选取方案为:(1为取)" << endl;
	maxVlue = branchAndBound(items, c);
	cout << "最大价值为:" << maxVlue << endl;
	cout << "队列中元素最多为：" << maxSize << endl;
	cout << "搜索次数为：" << searchCount << "" << endl;
	return 0;
}
 
int branchAndBound(Item items[], int c) {
	int x[N] = { 0 };
	int maxValue;			                              //保存当前搜索到的最大价值
	Node *maxNode = new Node();                           //保存当前最大价值节点（叶节点）
	priority_queue<Node *, vector<Node *>, cmp> maxQueue; //最大价值优先队列
	Node *firstNode, *curNode;
 
	searchCount = 1;
	firstNode = new Node();
	firstNode->bound = maxBound(firstNode,items,c);
	firstNode->parent = NULL;
	maxQueue.push(firstNode);							      //入队第一个结点
	maxValue = 0;
	maxNode = firstNode;
	while (!maxQueue.empty())
	{
		curNode = maxQueue.top(); maxQueue.pop();
		//扩展左孩子结点
		if (curNode->weight + items[curNode->level].weight <= c) {	//最大重量限界
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
		//扩展右孩子结点
		if (maxBound(curNode, items, c)>maxValue) {					//最大价值上界限界
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
		//跟踪队列大小
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
//限界函数
float maxBound(Node *node, Item items[], int c) {			//求以该节点为根的子树能达到的价值上界
	float maxValue;
	int restCapacity;				//扩展到该节点时的剩余容量
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