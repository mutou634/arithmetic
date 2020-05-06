package demo;
/**
 * 大整数相乘
 */
public class BigInteger {
 
	public static int sign(long a) {
 
		return a < 0 ? -1 : 1;
 
	}
 
	public static double bigdataride(long x,long y,int n) {
 
		x = Math.abs(x);  //返回绝对值
 
		y = Math.abs(y);
 
		if (n == 1) {  //截止
			
			return x * y;
 
		}
 
		else {
			if (n%2==1) {
				n = n - 1; //对奇数的操作
			}
			long a = (long) (x /Math.pow( 10 , (n / 2)));//Math.pow()以x为底，y为指数
 
			long b = x - a * Math.round(Math.pow( 10 , (n / 2)));
                                                    //Math.round()四舍六入，用XX00-yy;
			long c = y / Math.round(Math.pow( 10 , (n / 2)));
 
			long d = y - c * Math.round(Math.pow( 10 , (n / 2)));
 
			double ac = bigdataride(a,c,n/2);//递归计算a*c
 
			double bd = bigdataride(b,d,n/2);//计算b*d
                                      //划分左右计算
			//计算公式：xy=ac+((b-a)*(c-d)+ac+bd)+bd;
			long aJb = b + a;
 
			long cJd = c + d;
 
			double abcd = bigdataride(aJb,cJd,n/2);
 
			return (ac*Math.pow(10,n) + (abcd - ac - bd)*Math.pow(10,n/2) +bd);
 
		}
 
	}
 
	public static void main(String[] args) {
 
		// 大整数相乘
		long x = 33422783334L;
 
		long y = 25655743442L;
 
		String sx = String.valueOf(x); //返回x的字符串表现形式
 
		int n = sx.length();
 
		long sig = sign(x)*sign(y);   //保存结果正负
		long start = System.currentTimeMillis();
		double s = bigdataride(x,y,n);
 
		System.out.println("大数相乘的计算结果为："+s*sig);
		long end = System.currentTimeMillis();
		System.out.println("程序运行时间："+(end-start)+"ms");
		
		long x1=26563442481L,y1=32257763343L;
		long start2 = System.currentTimeMillis();
		System.out.println(x1*y1);
		long end2 = System.currentTimeMillis();
		System.out.println("程序运行时间："+(end2-start2)+"ms");

	}
 
}