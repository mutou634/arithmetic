package demo;

public class MatrixContinuousMultiplication {
    private static int solution(int a[],int memo[][],int s[][],int n) {
    	int answer,i=0,j=1;   //�ڶ�б�߿�ʼ��j
    	while(i<n-1) {      //ֱ�Ӹ�ֵ��һб�ߣ�����������жϲ�ֵ��
    		memo[i][i]=0;
    	}
    	while(j<n-1) {      //�߽���j������
    		int temp=j;
    		for(i=0;temp<n-1;i++,temp++) {
    			int temp2=temp-i;
    			for()
    		}
    	}
    	return answer;
    }
	public static void main(String[] args) {
		int a[]= {30,35,15,5,10,20,25};
		int n=a.length;
		int m[][]=new int[n-1][n-1];
		int s[][]=new int[n-1][n-1];
		System.out.println(solution(a,m,s,n));
	}

}
