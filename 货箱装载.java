#include <stdio.h>
#include <stdlib.h>
#define NUM 100
int n;  //集装箱数量
int W;  //轮船载重量
int w[NUM]; //集装箱重量
int x[NUM]; //当前搜索的解向量
int r;  //剩余集装箱重量
int cw; //当前轮船载重量
int bestw;  //最优载重
int bestx[NUM]; //最优解向量

void init()
{
    int i;
    bestw=0;  // 最优载重量初始化为0
    printf("请输入各集装箱的重量：");
    for( i=1;i<=n;i++)
    {
        scanf("%d",&w[i]);
        r+=w[i];
    }
}

//形参代表搜索第t层节点,从1开始
void BackTrack(int t)
{
    int i;
    //到达叶子节点, 此时就找到了一个可行解，然后就更新最优解向量和最优载重
    if(t>n)  
    {
        for(i=1;i<=n;i++)
        {
            bestx[i]=x[i];
        }
        bestw=cw;
    }
    else  // 未到达叶子节点
    {
        r-=w[t];    //先假设当前货箱可以装入，再判断能不能装入，因此这里要更新剩余集装箱重量
 
        //没有超出载重量
        if(cw+w[t]<=W) 
        {
            x[t]=1;  // 可以装入，则赋值为1
            cw+=w[t];  // 更新当前装入的总重量
            BackTrack(t+1);  // 递归进入下一货箱, 只要不超在，就会一直深度搜索下去
            cw-=w[t];   //返回时要将当前载重量还原，即回溯
        }
    
        //如果当前载重量加上剩余集装箱的重量没有超过前一个最优装载量的话就不用考虑了
        //此处即为剪枝函数，剪枝之前，至少有一个可行解已经产生
        if(cw+r>bestw)      
        {
            x[t]=0;     // 如果进入这个if 语句就说明，以该节点的子树不能剪，但通过上一个if语句的回溯后，该节点进入另一个选择，应赋值为0
            BackTrack(t+1);  //递归进入下一货箱
        }
        r+=w[t];    //返回时还原剩余集装箱重量，即回溯
    }
    return;
}

void print() // 打印函数
{
    int i;
    printf("最优载重：%d\n",bestw);
    printf("最佳解向量为：");
    for(i=1;i<=n;i++)
        printf("%d",bestx[i]);
    printf("\n即：");
    for(i=1;i<=n;i++)
    {
        if(bestx[i]==1)
            printf("\n第%d个货箱（重量为：%d）, 装入轮船",i,w[i]);
        else
            printf("\n第%d个货箱（重量为：%d）, 不装入轮船",i,w[i]);
    }
    printf("\n");
}

void main()
{
    printf("请输入集装箱的个数：");
    scanf("%d",&n);
    printf("请输入轮船的载重量：");
    scanf("%d",&W);
    init();
    BackTrack(1);
    print();
    system("pause");
}