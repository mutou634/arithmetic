package arithmeticDemo;
import java.util.Scanner;

public class TXSFTest
{
	public static int[] zhonliang = { 35, 30, 60, 50, 40, 10, 25 };
	public static int[] jiazhi = { 10, 40, 30, 50, 35, 40, 30 };

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int zonzhong=sc.nextInt();//������
		
		//���ú���
		maxJiaZhi(zonzhong);		
	}

	//���ֵ
	private static void maxJiaZhi(int zonzhong) {
		//�洢�ۼӵ������ͼ�ֵ
		int maxZhong=0;
		int maxJia=0;
		//����ܶ�
		double[] midu=new double[7];
		//�������������
		int [] index=new int[7];
		for (int i = 0; i < midu.length; i++)
		{
			midu[i]=(double)jiazhi[i]/zhonliang[i];	
			index[i]=i;
		}
		//ð������
		for (int i = 0; i < midu.length-1; i++)
		{
			for (int j = 0; j < midu.length-1-i; j++)
			{
				if (midu[j]<midu[j+1])
				{
					double temp=midu[j];
					midu[j]=midu[j+1];
					midu[j+1]=temp;
					
					//�������Ž���
					int temp1=index[j];
					index[j]=index[j+1];
					index[j+1]=temp1;
				}
			}
		}
		
		//�������Ž�
		for (int i = 0; i < index.length; i++)
		{
			if (zhonliang[index[i]]<=zonzhong)
			{
				maxZhong+=zhonliang[index[i]];
				maxJia+=jiazhi[index[i]];
				zonzhong-=zhonliang[index[i]];
			}
		}
		
		System.out.println("��������"+maxZhong);
		System.out.println("�ܼ�ֵ��"+maxJia);
	}

}