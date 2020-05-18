package arithmeticDemo;
import java.util.Arrays;
/*
 * �����Ǻ��ѵ��㷨����Ҫ����Ϥ̰���㷨�ĸ����Ҫ���ļ���
 */
public class Activity {
	    public static int greedySelector(int[] s, int[] f, boolean[] a) {
	        int n = s.length - 1;
	        a[1] = true;//��һ�����ѡ��
	        int j = 1;
	        int count = 1;//��ѡ�л��������Ĭ�ϵ�һ�����ѡ��
	        for (int i = 2; i <= n; i++) {
	            if (s[i] >= f[j]) {//��һ�����ʼʱ����ڴ��ڵ�����һ�������ʱ��
	                a[i] = true;
	                j = i;
	                count++;
	            } else {
	                a[i] = false;
	            }
	        }
	        return count;
	    }
	    public static void main(String[] args) {
	        int s[] = {-1, 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};//Ĭ���±��1��ʼ���ѷǼ����ź��򣩣���ʼ��-1����
	        int f[] = {-1, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
	        boolean[] a = new boolean[s.length];
	        int counts = greedySelector(s, f, a);
	        System.out.println("�������������ݻ����Ϊ:" + counts);
	        for (int i = 1; i <= s.length - 1; i++) {
	            if (a[i]) {
	                System.out.println("��" + i + "���ѡ��");
	            }
	        }
	    }
}
