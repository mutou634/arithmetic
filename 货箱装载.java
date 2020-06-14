package arithmeticDemo;

import javax.swing.*;
import java.util.Scanner;
public class Loading {
    private int n;//��װ����
    private int[] w;//��װ����������
    private int c;//��һ���ִ���������
    private int cw;//��ǰ������
    private int bestw;//��ǰ����������
    private int r;//ʣ�༯װ������
    private int[] x;//��ǰ��
    private int[] bestx;//��ǰ���Ž�

    /**
     *
     * @param i
     */
    public void backtrace(int i) {
        //1.����Ҷ�ڵ�
        if (i > n-1) {   //i��ʱ��ֵ=Ҷ�ڵ�+1
            if (cw > bestw) {
                for (int j = 0; j < n; j++) {
                    bestx[j] = x[j];
                    bestw = cw;
                }
                return;
            }
        }
        r -= w[i];
        //2.����������
        if (cw + w[i] < c) {   //x[i =1
            x[i] = 1;
            cw += w[i];
            backtrace(i + 1);
            cw -= w[i];
        }
        //3.����������
        if (cw + r > bestw) {
            x[i] = 0;
            backtrace(i + 1);
        }
        r += w[i];
    }

    public static void main(String[] args) {
        Loading X = new Loading();
        /*String s1 = JOptionPane.showInputDialog(null, "�������������",
                "����װ������", JOptionPane.QUESTION_MESSAGE);*/
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        X.n = Integer.parseInt(s1);
        X.w = new int[X.n];
        X.x = new int[X.n];
        X.bestx= new int[X.n];
        System.out.println("���������������飺");
        for (int i = 0; i < X.n; i++) {
            X.w[i] = (int) (100 * Math.random());
            System.out.println(X.w[i]);
        }
        /*String s2 = JOptionPane.showInputDialog(null, "�����һ���ִ�����������",
                "����װ������", JOptionPane.QUESTION_MESSAGE);*/

        String s2 = scanner.nextLine();
        X.c = Integer.parseInt(s2);

        for (int i = 0; i < X.n; i++)
            X.r += X.w[i];
        X.backtrace(0);
        System.out.print("�����ǰ���Ž�:");
        for (int i = 0; i < X.n; i++) System.out.print(X.bestx[i] + " ");
        System.out.println();
        System.out.println("���Ž⣺" + X.bestw);
    }
}
