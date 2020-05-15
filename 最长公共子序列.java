package arithmeticDemo;
//最长公共子序列问题
public class Lcs {
	static int pass=0;
	public static int max(int i,int j) {
		return i>j?i:j;
	}
    public static int solve(int x[],int y[],int n1,int n2,int m[][]) {
    	for(int j=0;j<=n2;j++) {
    		m[0][j]=0;
    	}
    	for(int i=1;i<=n1;i++) {
    		m[i][0]=0;
    	}
    	for(int i=1;i<=n1;i++) {
    		for(int j=1;j<=n2;j++) {
    			if(x[i-1]==y[j-1]) 
    				m[i][j]=m[i-1][j-1]+1;
    			else 
    				m[i][j]=max(m[i-1][j],m[i][j-1]);
    		}
    	}
    	return m[8][9];
    }
    public static void traceBack(int x[],int y[],int m[][],int answer[],int a,int b) {
    	System.out.print(a);
    	System.out.println(b);
    	while(a>0&&b>0) {
    	if(x[a-1]==y[b-1]) {
    		answer[pass++]=x[a-1];
    	    traceBack(x,y,m,answer,a-1,b-1);
    	}
    	else if(m[a][b]==m[a-1][b]) {
    		traceBack(x,y,m,answer,a-1,b);
    	}
    	else  traceBack(x,y,m,answer,a,b-1);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a[]= {1,3,4,5,6,7,7,8};
        int b[]= {3,5,7,4,8,6,7,8,2};
        int n1=a.length;
        int n2=b.length;
        int m[][]=new int[n1+1][n2+1];
        int n3=solve(a,b,n1,n2,m);
        System.out.println(n3);
        int[] answer=new int[n3];
        traceBack(a,b,m,answer,n1,n2);
        for(int i=0;i<n3;i++) {
        	System.out.println(answer[i]);
        }
      }

}
