package ��ͨ��;
import java.util.Scanner;
abstract class traffic{
	public int speed;
	public String type;
	public String clue;
        public abstract void setspeed();
        public abstract void setclue();
        public abstract String gettype();
    
}
public class Java1 extends traffic{
     static String type="С����";
     static int seat=4;
     public void setspeed() {
    	 System.out.println("���������������ٶȣ�");
     	 Scanner sur=new Scanner(System.in);
     	 speed=sur.nextInt();
     }
     public void setclue() {
    	 System.out.println("���������������ɫ��");
    	 Scanner sur1=new Scanner(System.in);
    	 clue=sur1.next();
     }
     public String gettype() {
    	 System.out.println("�������������ǣ�");
    	 return type;
     }
     public int getseat() {
    	System.out.println("�����λ��Ϊ��");
    	 return seat;
     }
     public int getspeed() {
    	 System.out.println("��������ٶ�Ϊ��");
    	 return speed;
     }
     public String getclue() {
    	 System.out.println("����������ɫ�ǣ�");
    	 return clue;
     }
     public static void main(String[] args) {
    	 Java1 small=new Java1();
    	 small.setspeed();
    	 small.setclue();
    	 System.out.println(small.gettype());
    	 System.out.println(small.getspeed());
    	 System.out.println(small.getclue());
    	 System.out.println("����������λ��Ϊ��"+seat);
     }
}
