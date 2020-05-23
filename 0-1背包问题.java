package arithmeticDemo;
import java.util.Scanner;

public class TXSFTest
{
	public static int[] zhonliang = { 35, 30, 60, 50, 40, 10, 25 };
	public static int[] jiazhi = { 10, 40, 30, 50, 35, 40, 30 };

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int zonzhong=sc.nextInt();//总重量
		
		//调用函数
		maxJiaZhi(zonzhong);		
	}

	//求价值
	private static void maxJiaZhi(int zonzhong) {
		//存储累加的重量和价值
		int maxZhong=0;
		int maxJia=0;
		//存放密度
		double[] midu=new double[7];
		//存放索引的数组
		int [] index=new int[7];
		for (int i = 0; i < midu.length; i++)
		{
			midu[i]=(double)jiazhi[i]/zhonliang[i];	
			index[i]=i;
		}
		//冒泡排序
		for (int i = 0; i < midu.length-1; i++)
		{
			for (int j = 0; j < midu.length-1-i; j++)
			{
				if (midu[j]<midu[j+1])
				{
					double temp=midu[j];
					midu[j]=midu[j+1];
					midu[j+1]=temp;
					
					//索引跟着交换
					int temp1=index[j];
					index[j]=index[j+1];
					index[j+1]=temp1;
				}
			}
		}
		
		//计算最优解
		for (int i = 0; i < index.length; i++)
		{
			if (zhonliang[index[i]]<=zonzhong)
			{
				maxZhong+=zhonliang[index[i]];
				maxJia+=jiazhi[index[i]];
				zonzhong-=zhonliang[index[i]];
			}
		}
		
		System.out.println("总重量："+maxZhong);
		System.out.println("总价值："+maxJia);
	}

}