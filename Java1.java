package 交通类;
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
     static String type="小汽车";
     static int seat=4;
     public void setspeed() {
    	 System.out.println("请输入你汽车的速度：");
     	 Scanner sur=new Scanner(System.in);
     	 speed=sur.nextInt();
     }
     public void setclue() {
    	 System.out.println("请输入你的汽车颜色：");
    	 Scanner sur1=new Scanner(System.in);
    	 clue=sur1.next();
     }
     public String gettype() {
    	 System.out.println("你汽车的类型是：");
    	 return type;
     }
     public int getseat() {
    	System.out.println("你的座位数为：");
    	 return seat;
     }
     public int getspeed() {
    	 System.out.println("你的汽车速度为：");
    	 return speed;
     }
     public String getclue() {
    	 System.out.println("你汽车的颜色是：");
    	 return clue;
     }
     public static void main(String[] args) {
    	 Java1 small=new Java1();
    	 small.setspeed();
    	 small.setclue();
    	 System.out.println(small.gettype());
    	 System.out.println(small.getspeed());
    	 System.out.println(small.getclue());
    	 System.out.println("你汽车的座位数为："+seat);
     }
}
