package arithmeticDemo;
import java.util.Arrays;
import java.util.Scanner;
public class DynamicProgramming {
    private static Scanner sc;
	public static void Build(int number,int weight[],int value[]){
    	    Scanner sc = new Scanner(System.in);
			weight[0] = 0;
			for (int i = 1; i < number + 1; i++) {
				weight[i] = sc.nextInt();
			}
 
			value[0] = 0;
			for (int i = 1; i < number + 1; i++) {
				value[i] = sc.nextInt();
			}
 
			int capacity = sc.nextInt(); // ��������
            sc.close();
			/* 2.���01�������� */
			// ������̬�滮��.����v[i][j]��Ӧ�ڣ���ǰ��i����Ʒ��ѡ��
			//���ҵ�ǰ����������Ϊjʱ�������ܵõ�������ֵ
			int[][] v = new int[number + 1][capacity + 1];
 
			// �̬�滮����ǰ��i����Ʒ��ѡ�����ҵ�ǰ����������Ϊj��
			for(int i=0;i<=number;i++)  v[i][0]=0;
			for(int j=0;j<capacity;j++) v[0][j]=0;
			for (int i = 1; i < number + 1; i++) {
				for (int j = 1; j < capacity + 1; j++) {
						if (j < weight[i]) {
							v[i][j] = v[i - 1][j];// ���������ȵ�ǰ����Ʒ���С��
							//װ���£���ʱ�ļ�ֵ��ǰi-1���ļ�ֵ��һ���ģ�
							//��V(i,j)=V(i-1,j)��
						} else {
	// �����㹻����������װ��ǰ����Ʒ����װ�˵�ǰ��ƷҲ��һ���ﵽ��ǰ���ż�ֵ��
	//������װ�벻װ֮��ѡ�����ŵ�һ������V(i,j)=max��V(i-1,j)��V(i-1,j-w(i))+v(i)����							
							v[i][j] = Math.max(v[i - 1][j], v[i - 1][j - weight[i]] + value[i]);
						}
					}
			}
			Print(v,capacity,number,weight);
 }
public static void Print(int v[][],int capacity,int number,int weight[]) {
	 System.out.println();
		System.out.println("��̬�滮�����£�");
		for (int i = 0; i < number + 1; i++) {
			for (int j = 0; j < capacity + 1; j++) {
				System.out.print(v[i][j] + "\t");
			}
			System.out.println();
		}
		// ��number����Ʒ��ѡ���ұ���������Ϊcapacity������£���װ�뱳��������ֵ
		System.out.println("������������Ʒ��ֵ�ܺ�Ϊ��" + v[number][capacity]);

		/* 3.��ֵ���ʱ������װ������Щ��Ʒ�� */

		int[] item = new int[number + 1];// �±�i��Ӧ����Ʒ����ѡ�У�����ֵΪ1
		Arrays.fill(item, 0);// ������item������Ԫ�س�ʼ��Ϊ0

		// �����Ž⣬���ƻ�ȥ��
		int j = capacity;
		for (int i = number; i > 0; i--) {
			if (v[i][j] > v[i - 1][j]) {// �����Ž��У�v[i][j]>v[i-1][j]˵��ѡ���˵�i����Ʒ
				item[i] = 1;
				j = j - weight[i];
			}
		}

		System.out.print("������Ʒ�ı��Ϊ��");
		for (int i = 0; i < number + 1; i++) {
			if (item[i] == 1) {
				System.out.print(i + " ");
			}
		}
		System.out.println("----------------------------");

}
public static void main(String[] args) {
            sc = new Scanner(System.in);
            int number=sc.nextInt();
            int weight[]=new int[number+1];
            int value[]=new int[number+1];
            Build(number,weight,value);
//print();
}
}