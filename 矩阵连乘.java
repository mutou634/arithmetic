package demo;
//动态规划求解矩阵连乘括号问题
//m二维数组记录子问题的最少次数，s数组记录各元素的最好二分位置
public class MatrixContinuousMultiplication {
    private static int solution(int a[],int memo[][],int s[][],int n) {
    	int i=0,j=1;   //第二斜线开始用j
    	while(i<n-1) {      //直接赋值第一斜线，合起来多加判断不值得
    		memo[i][i]=0;
    		i++;
    	}
    	while(j<n-1) {      //有多少条斜线
    		int temp=j;
    		for(i=0;temp<n-1;i++,temp++) {   //temp记录每条斜线的元素个数
    			memo[i][temp]=memo[i+1][temp]+a[i]*a[i+1]*a[temp+1];
    			s[i][temp]=i;
    			for(int k=i+1;k<temp;k++) {   //k为对二维数组元素的划分
    				int temp2=memo[i][k]+memo[k+1][temp]+a[i]*a[k+1]*a[temp+1];
    				if(temp2<memo[i][temp])  {
    					memo[i][temp]=temp2;
    				    s[i][temp]=k;
    				}
    			}
    		}
    		j++;
    	}
    	return memo[0][n-2];
    }
    //递归输出算式（有时间好好看看）
    private static void traceBack(int s[][],int i,int j) {
    	if(i==j) 
			System.out.print("A"+(i+1));    
		else if(i+1==j) 
			System.out.print(" (A"+(i+1)+" * "+" A"+(j+1)+") ");   
		else{     
			System.out.print(" (");   
			traceBack(s,i,s[i][j]);   
			traceBack(s,s[i][j]+1,j);      
			System.out.print(") ");    
		}
    }
	public static void main(String[] args) {
		int a[]= {30,35,15,5,10,20,25};
		int n=a.length;
		int m[][]=new int[n-1][n-1];
		int s[][]=new int[n-1][n-1];
		System.out.println("最少乘法次数:"+solution(a,m,s,n));
		System.out.println("最后算式：");
		traceBack(s,0,n-2);
	}

}
