package arithmeticDemo;

import java.util.Scanner;

public class FourColor {
	static int[][] e = new int[6][6]; //存储各个边的情况连同为1 不连为0
	static int[] state = new int[e.length]; //表示当前染色情况
	static int Colornum = 4;//共有几种颜色
    //先进行涂色，再递归入口进行判断是否可行
	static void sear(int index) {//递归函数
		if (isOk(index)) {//判断当前状态能否满足条件
			if (index == e.length - 1) {//若已经染到最后一个节点则输出情况
				Show(index);
			} else {
				for (int i = 1; i <= Colornum; i++) {//将所有 的颜色情况给遍历 
					state[index + 1] = i;//假如下一个染色，
					sear(index + 1);//进入下次递归并且在递归的入口判断是否满足条件
				}
			}

		}
	}
//打印当前状态
	private static void Show(int index) {
		for (int i = 1; i <= index; i++) {
			System.out.println(i + "is " + "Color " + state[i]);
		}

		System.out.println();
	}
//判断是否能染色
	private static boolean isOk(int index) {
		for (int i = 1; i < index; i++) {
			if (e[index][i] == 1 && state[i] == state[index])//当两个节点是连同并且颜色一样则不满足返回false
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		//输入边的情况
		for (int i = 1; i <= n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			e[a][b] = 1;
			e[b][a] = 1;
		}
		//从0开始递归，但0不是一个节点
		sear(0);
	}

}