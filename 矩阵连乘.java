package demo;
//��̬�滮������������������
//m��ά�����¼����������ٴ�����s�����¼��Ԫ�ص���ö���λ��
public class MatrixContinuousMultiplication {
    private static int solution(int a[],int memo[][],int s[][],int n) {
    	int i=0,j=1;   //�ڶ�б�߿�ʼ��j
    	while(i<n-1) {      //ֱ�Ӹ�ֵ��һб�ߣ�����������жϲ�ֵ��
    		memo[i][i]=0;
    		i++;
    	}
    	while(j<n-1) {      //�ж�����б��
    		int temp=j;
    		for(i=0;temp<n-1;i++,temp++) {   //temp��¼ÿ��б�ߵ�Ԫ�ظ���
    			memo[i][temp]=memo[i+1][temp]+a[i]*a[i+1]*a[temp+1];
    			s[i][temp]=i;
    			for(int k=i+1;k<temp;k++) {   //kΪ�Զ�ά����Ԫ�صĻ���
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
    //�ݹ������ʽ����ʱ��úÿ�����
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
		System.out.println("���ٳ˷�����:"+solution(a,m,s,n));
		System.out.println("�����ʽ��");
		traceBack(s,0,n-2);
	}

}
