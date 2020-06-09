package arithmeticDemo;
import java.util.Scanner;
public class OneZero {
private static int[] p;//物品的价值数组
private static int[] w;//物品的重量数组
private static int c;//最大可以拿的重量
private static int count;//物品的个数

private static int cw;//当前的重量
private static int cp;//当前的价值
static int bestp;//目前最优装载的价值
private static int r;//剩余物品的价值

private static int[] cx;//存放当前解
private static int[] bestx;//存放最终解

public static void Loading() {
    cw = 0;
    bestp = 0;
    cx = new int[count+1];
    bestx = new int [count+1];
    //初始化r，即剩余最大价格
    for(int i = 1;i<=count;i++) {
        r += p[i];
    }
    //调用回溯法计算
    BackTrack(1);
}

public static void BackTrack(int t) {
    if(t>count) {//到达叶结点
        if(cp>bestp) {
           for(int i = 1;i<=count;i++) {
                bestx[i] = cx[i];
          }
        	//bestx=cx;   不能这样写，因为这样其实是直接给地址，后cx变化，bestx也会改变
            bestp = cp;
            return;
        }
        return;
    }

    r -= p[t];
    if(cw + w[t] <= c) {//搜索左子树
        cx[t] = 1;
        cp += p[t];
        cw += w[t];
        BackTrack(t+1);
        cp -= p[t];//恢复现场
        cw -= w[t];//恢复现场

    }

    if(cp + r >bestp) {//剪枝操作
        cx[t] = 0;//搜索右子树
        BackTrack(t+1);
    }
    r += p[t];//恢复现场
}
public static void main(String[] args) {
    //测试
	Scanner in=new Scanner(System.in); 
	System.out.println("请输入物品个数：");
	int length=in.nextInt();
	w=new int[length+1];   w[0]=0;
	p=new int[length+1];   p[0]=0;
	System.out.println("请依次输入物品重量、价值：");
	for(int i=1;i<=length;i++) {
		w[i]=in.nextInt();
		p[i]=in.nextInt();
	}
	count=length;
	System.out.println("请输入背包可承受最大重量：");
    c=in.nextInt();
    in.close();
    Loading();
    System.out.println("最优装载为：" + bestp);
    for(int i =1;i<=count;i++) {
        System.out.print(bestx[i] + " ");
    }           
  }
}