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
		System.out.println("请输入一个整数:");
		try{
			int x=snack.nextInt();
			System.out.println("是否为snack整数:"+Solution2.isPalindrome(x));
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
检查一个整数是否为回文数
负数必不为回文数
利用将整数拟写算法与之前的数进行比较
*/