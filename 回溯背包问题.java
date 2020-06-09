package arithmeticDemo;
import java.util.Scanner;
public class OneZero {
private static int[] p;//��Ʒ�ļ�ֵ����
private static int[] w;//��Ʒ����������
private static int c;//�������õ�����
private static int count;//��Ʒ�ĸ���

private static int cw;//��ǰ������
private static int cp;//��ǰ�ļ�ֵ
static int bestp;//Ŀǰ����װ�صļ�ֵ
private static int r;//ʣ����Ʒ�ļ�ֵ

private static int[] cx;//��ŵ�ǰ��
private static int[] bestx;//������ս�

public static void Loading() {
    cw = 0;
    bestp = 0;
    cx = new int[count+1];
    bestx = new int [count+1];
    //��ʼ��r����ʣ�����۸�
    for(int i = 1;i<=count;i++) {
        r += p[i];
    }
    //���û��ݷ�����
    BackTrack(1);
}

public static void BackTrack(int t) {
    if(t>count) {//����Ҷ���
        if(cp>bestp) {
           for(int i = 1;i<=count;i++) {
                bestx[i] = cx[i];
          }
        	//bestx=cx;   ��������д����Ϊ������ʵ��ֱ�Ӹ���ַ����cx�仯��bestxҲ��ı�
            bestp = cp;
            return;
        }
        return;
    }

    r -= p[t];
    if(cw + w[t] <= c) {//����������
        cx[t] = 1;
        cp += p[t];
        cw += w[t];
        BackTrack(t+1);
        cp -= p[t];//�ָ��ֳ�
        cw -= w[t];//�ָ��ֳ�

    }

    if(cp + r >bestp) {//��֦����
        cx[t] = 0;//����������
        BackTrack(t+1);
    }
    r += p[t];//�ָ��ֳ�
}
public static void main(String[] args) {
    //����
	Scanner in=new Scanner(System.in); 
	System.out.println("��������Ʒ������");
	int length=in.nextInt();
	w=new int[length+1];   w[0]=0;
	p=new int[length+1];   p[0]=0;
	System.out.println("������������Ʒ��������ֵ��");
	for(int i=1;i<=length;i++) {
		w[i]=in.nextInt();
		p[i]=in.nextInt();
	}
	count=length;
	System.out.println("�����뱳���ɳ������������");
    c=in.nextInt();
    in.close();
    Loading();
    System.out.println("����װ��Ϊ��" + bestp);
    for(int i =1;i<=count;i++) {
        System.out.print(bestx[i] + " ");
    }           
  }
}