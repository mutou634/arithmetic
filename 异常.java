package 异常;
class Java2{
	static void mian2() {
	try {
		throw new NullPointerException("demol");
		}
	catch(NullPointerException e) {
	  System.out.println("空指针异常");throw e;
	}
	}
}
public class Java1{
	public static void main(String[] args) {
		try {
			Java2.mian2();
		}
		catch(NullPointerException e) {
			System.out.println("你看看那"+e);
		}finally {
			System.out.println("end");
		}
		
	}
}    