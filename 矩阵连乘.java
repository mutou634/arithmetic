package demo;

public class MatrixContinuousMultiplication {
    private static int solution(int a[],int memo[][],int s[][],int n) {
    	int answer,i=0,j=1;   //第二斜线开始用j
    	while(i<n-1) {      //直接赋值第一斜线，合起来多加判断不值得
    		memo[i][i]=0;
    	}
    	while(j<n-1) {      //边界由j来决定
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
