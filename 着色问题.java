package arithmeticDemo;

import java.util.Scanner;

public class FourColor {
	static int[][] e = new int[6][6]; //�洢�����ߵ������ͬΪ1 ����Ϊ0
	static int[] state = new int[e.length]; //��ʾ��ǰȾɫ���
	static int Colornum = 4;//���м�����ɫ
    //�Ƚ���Ϳɫ���ٵݹ���ڽ����ж��Ƿ����
	static void sear(int index) {//�ݹ麯��
		if (isOk(index)) {//�жϵ�ǰ״̬�ܷ���������
			if (index == e.length - 1) {//���Ѿ�Ⱦ�����һ���ڵ���������
				Show(index);
			} else {
				for (int i = 1; i <= Colornum; i++) {//������ ����ɫ��������� 
					state[index + 1] = i;//������һ��Ⱦɫ��
					sear(index + 1);//�����´εݹ鲢���ڵݹ������ж��Ƿ���������
				}
			}

		}
	}
//��ӡ��ǰ״̬
	private static void Show(int index) {
		for (int i = 1; i <= index; i++) {
			System.out.println(i + "is " + "Color " + state[i]);
		}

		System.out.println();
	}
//�ж��Ƿ���Ⱦɫ
	private static boolean isOk(int index) {
		for (int i = 1; i < index; i++) {
			if (e[index][i] == 1 && state[i] == state[index])//�������ڵ�����ͬ������ɫһ�������㷵��false
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		//����ߵ����
		for (int i = 1; i <= n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			e[a][b] = 1;
			e[b][a] = 1;
		}
		//��0��ʼ�ݹ飬��0����һ���ڵ�
		sear(0);
	}

}