public class Maopao {
     public static void maopao(int[] a) {
    	 int len=a.length;
    	 for(int i=0;i<len-1;i++)
    		 for(int j=0;j<len-1-i;j++) {
    			 if(a[j]>a[j+1]) {
    				 a[j]=a[j]+a[j+1];
    				 a[j+1]=a[j]-a[j+1];
    				 a[j]=a[j]-a[j+1];
    			 }
    		 }
    	 for(int x:a) {
    		 System.out.println(x);
    	 }
     }
     public static void maopao2(int[] a) {
    	 int len=a.length;
    	 for(int i=0;i<len-1;i++)
    		 for(int j=len-1;j>i;j--) {
    			 if(a[j-1]<a[j]) {
    			   a[j]=a[j-1]+a[j];
    			   a[j-1]=a[j]-a[j-1];
    			   a[j]=a[j]-a[j-1];
    			 }
    		 }
    	 for(int x:a) {
    		 System.out.println(x);
    	 }
     }
     public static void main(String[] args) {
    	 int a2[]= {12,34,3,56,45,99,34,5};
    	 Maopao.maopao(a2);
    	 Maopao.maopao2(a2);
     }
}
/*������ð�ŵ�forѭ������foreachѭ����foreach�����java5��������֮һ���ڱ������顢���Ϸ��棬foreachΪ������Ա�ṩ�˼���ķ��㡣
foreach�����for��������򻯰汾������foreach��䲢������ȫȡ��for��䣬Ȼ�����κε�foreach��䶼���Ը�дΪfor���汾��
foreach������һ���ؼ��֣�ϰ���Ͻ����������for����ʽ��֮Ϊ��foreach����䡣��Ӣ��������˼���foreachҲ���ǡ�for ÿһ��������˼��ʵ����Ҳ���������˼��
foreach������ʽ��
for(Ԫ������t Ԫ�ر���x : ��������obj)*/