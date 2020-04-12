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
/*这种有冒号的for循环叫做foreach循环，foreach语句是java5的新特征之一，在遍历数组、集合方面，foreach为开发人员提供了极大的方便。
foreach语句是for语句的特殊简化版本，但是foreach语句并不能完全取代for语句，然而，任何的foreach语句都可以改写为for语句版本。
foreach并不是一个关键字，习惯上将这种特殊的for语句格式称之为“foreach”语句。从英文字面意思理解foreach也就是“for 每一个”的意思。实际上也就是这个意思。
foreach的语句格式：
for(元素类型t 元素变量x : 遍历对象obj)*/