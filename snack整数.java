package demo;
import java.util.Scanner;
class Solution2 {
    public static boolean isPalindrome(int x) {
        int pass=0;
        int temp=x;
        if(x<0) return false;
        else while(temp!=0){
            pass=pass*10+temp%10;
            temp=temp/10;
        }
        return pass==x?true:false;
    }
}
public class Snack {
	public static void main(String[] args) {
		Scanner snack=new Scanner(System.in);
		System.out.println("������һ������:");
		try{
			int x=snack.nextInt();
			System.out.println("�Ƿ�Ϊsnack����:"+Solution2.isPalindrome(x));
		}
		catch(java.util.InputMismatchException e) {
			System.out.println("error:"+e);
		}
		finally {
			System.out.println("The program is end!");
		}
		snack.close();
	}
}
/*
���һ�������Ƿ�Ϊ������
�����ز�Ϊ������
���ý�������д�㷨��֮ǰ�������бȽ�
*/