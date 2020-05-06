package demo;
/**
 * ���������
 */
public class BigInteger {
 
	public static int sign(long a) {
 
		return a < 0 ? -1 : 1;
 
	}
 
	public static double bigdataride(long x,long y,int n) {
 
		x = Math.abs(x);  //���ؾ���ֵ
 
		y = Math.abs(y);
 
		if (n == 1) {  //��ֹ
			
			return x * y;
 
		}
 
		else {
			if (n%2==1) {
				n = n - 1; //�������Ĳ���
			}
			long a = (long) (x /Math.pow( 10 , (n / 2)));//Math.pow()��xΪ�ף�yΪָ��
 
			long b = x - a * Math.round(Math.pow( 10 , (n / 2)));
                                                    //Math.round()�������룬��XX00-yy;
			long c = y / Math.round(Math.pow( 10 , (n / 2)));
 
			long d = y - c * Math.round(Math.pow( 10 , (n / 2)));
 
			double ac = bigdataride(a,c,n/2);//�ݹ����a*c
 
			double bd = bigdataride(b,d,n/2);//����b*d
                                      //�������Ҽ���
			//���㹫ʽ��xy=ac+((b-a)*(c-d)+ac+bd)+bd;
			long aJb = b + a;
 
			long cJd = c + d;
 
			double abcd = bigdataride(aJb,cJd,n/2);
 
			return (ac*Math.pow(10,n) + (abcd - ac - bd)*Math.pow(10,n/2) +bd);
 
		}
 
	}
 
	public static void main(String[] args) {
 
		// ���������
		long x = 33422783334L;
 
		long y = 25655743442L;
 
		String sx = String.valueOf(x); //����x���ַ���������ʽ
 
		int n = sx.length();
 
		long sig = sign(x)*sign(y);   //����������
		long start = System.currentTimeMillis();
		double s = bigdataride(x,y,n);
 
		System.out.println("������˵ļ�����Ϊ��"+s*sig);
		long end = System.currentTimeMillis();
		System.out.println("��������ʱ�䣺"+(end-start)+"ms");
		
		long x1=26563442481L,y1=32257763343L;
		long start2 = System.currentTimeMillis();
		System.out.println(x1*y1);
		long end2 = System.currentTimeMillis();
		System.out.println("��������ʱ�䣺"+(end2-start2)+"ms");

	}
 
}