package school;
import java.util.Scanner;
class bank{
	public String ac;
	public String na;
	public String ad;
	public long re;
	public long in;
	private Scanner su1;
	public void setac() {
		su1=new Scanner(System.in);
		ac=su1.next();
	}
	public void setna() {
		Scanner su2=new Scanner(System.in);
		na=su2.next();
	}
	public String getna() {
		return na;
	}
	public void setad() {
		Scanner su3=new Scanner(System.in);
		ad=su3.next();
	}
	public void setre() {
		Scanner su4=new Scanner(System.in);
		re=su4.nextLong();
	}
	public long getre() {
		return re;
	}
	public void inmoney() {
		System.out.println("请问你想存入多少钱:");
		Scanner su6=new Scanner(System.in);
		in=su6.nextLong();
		}
	public long getin() {
	  return in;
	}
	public void outmoney() {
		System.out.println("请问你想取出多少钱:");
		Scanner su7=new Scanner(System.in);
		long out=su7.nextLong();
		System.out.println("取个锤子，滚");
	}	
}
public class java5 {
	public static void main(String[] args) {
	 bank a=new bank();
     System.out.println("请创建你的账号名:");
     a.setac();
     System.out.println("请问你的名字是？");
     a.setna();
     System.out.println("请输入你的地址:");
     a.setad();
     System.out.println("输入你想存入的钱:");
     a.setre();
     System.out.println("恭喜"+a.getna()+"开户成功");
     System.out.println("请按键选择要进行的业务:1:存款 2:取款");
     Scanner su5=new Scanner(System.in);
     int b=su5.nextInt();
     if(b==1) 
    	 {
    	 a.inmoney();
    	 long e=a.getre()+a.getin();
         System.out.println("存入成功！当前余额为:"+e+"今日存款数:"+a.getin());
    	 }
     else if(b==2)
    	 a.outmoney();
     else 
        System.out.println("请输入正确的指令！");
     }
}