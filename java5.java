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
		System.out.println("��������������Ǯ:");
		Scanner su6=new Scanner(System.in);
		in=su6.nextLong();
		}
	public long getin() {
	  return in;
	}
	public void outmoney() {
		System.out.println("��������ȡ������Ǯ:");
		Scanner su7=new Scanner(System.in);
		long out=su7.nextLong();
		System.out.println("ȡ�����ӣ���");
	}	
}
public class java5 {
	public static void main(String[] args) {
	 bank a=new bank();
     System.out.println("�봴������˺���:");
     a.setac();
     System.out.println("������������ǣ�");
     a.setna();
     System.out.println("��������ĵ�ַ:");
     a.setad();
     System.out.println("������������Ǯ:");
     a.setre();
     System.out.println("��ϲ"+a.getna()+"�����ɹ�");
     System.out.println("�밴��ѡ��Ҫ���е�ҵ��:1:��� 2:ȡ��");
     Scanner su5=new Scanner(System.in);
     int b=su5.nextInt();
     if(b==1) 
    	 {
    	 a.inmoney();
    	 long e=a.getre()+a.getin();
         System.out.println("����ɹ�����ǰ���Ϊ:"+e+"���մ����:"+a.getin());
    	 }
     else if(b==2)
    	 a.outmoney();
     else 
        System.out.println("��������ȷ��ָ�");
     }
}