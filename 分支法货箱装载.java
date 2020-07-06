package arithmeticDemo;

public class Container {
		 public static void main(String[] args) {
		  // n������
		  int n = 3;
		  // ��һ�Ҵ���������
		  float c1 = 50;
		  // �ڶ��Ҵ���������
		  float c2 = 50;
		  // ������������
		  float[] w = { 0, 10, 40, 40 };

		  // ��������
		  Container bfis = new Container(n, c1, c2, w);
		  // ���л��������֮��
		  float s = bfis.getS();
		  if (s <= c1 || s <= c2) {
		   System.out.println("need only one ship!");
		  }
		  if (s > c1 + c2) {
		   System.out.println("no solution!");
		   return;
		  }

		  bfis.maxLoading(c1);

		  float bestw = bfis.getBestw();

		  if (s - bestw <= c2) {
		   System.out.println("The first ship loading " + bestw);
		   System.out.println("The second ship loading " + (s - bestw));
		  } else {
		   System.out.println("no solution!");
		  }

		 }

		 private int n; // n������
		 private float c1; // ��һ�Ҵ���������
		 private float c2; // �ڶ��Ҵ���������
		 private float bestw; // ��һ�Ҵ������װ��
		 private float ew = 0; // ��ǰ����װ����
		 private float[] w; // ������������
		 private float s = 0; // ���л��������֮��
		 private MyQueue mq = new MyQueue(); // FIFO����

		 /**
		  * ���췽��
		  */
		 public Container(int _n, float _c1, float _c2, float[] _w) {
		  n = _n;
		  c1 = _c1;
		  c2 = _c2;
		  w = _w;

		  for (float f : _w) {
		   s += f;
		  }
		 }

		 /**
		  * ����װ��ֵ
		  */
		 public float maxLoading(float c) {
		  mq.put(new Float(-1)); // ��ʼ�������У���Ƿֲ�
		  int i = 1; // E-���Ĳ�
		  ew = 0; // ��ǰ����װ����
		  bestw = 0; // Ŀǰ������ֵ

		  while (!mq.empty()) { // �����Ӽ��ռ���
		   if (ew + w[i] <= c) { // ���E-�������ӣ�����i�Ƿ����װ��
		    addLiveNode(ew + w[i], i); // ����i����װ��
		   }

		   addLiveNode(ew, i); // �Һ������ǿ��еģ���װ�ػ���i

		   ew = (Float) mq.get(); // ȡ��һ�����

		   if (ew == -1) { // ������β��
		    if (mq.empty()) {
		     return bestw;
		    }
		    mq.put(new Float(-1));
		    ew = (Float) mq.get(); // ȡ��һ�����
		    i++; // ew�Ĳ�
		   }
		  }
		  return bestw;
		 }
		 public void addLiveNode(float wt, int i) {
		  if (i == n) { // ��Ҷ��
		   if (wt > bestw) {
		    bestw = wt;
		   }
		  } else { // ����Ҷ��
		   mq.put(new Float(wt));
		  }
		 }

		 public int getN() {
		  return n;
		 }

		 public void setN(int n) {
		  this.n = n;
		 }

		 public float getC1() {
		  return c1;
		 }

		 public void setC1(float c1) {
		  this.c1 = c1;
		 }

		 public float getC2() {
		  return c2;
		 }

		 public void setC2(float c2) {
		  this.c2 = c2;
		 }

		 public float getBestw() {
		  return bestw;
		 }

		 public void setBestw(float bestw) {
		  this.bestw = bestw;
		 }

		 public float getEw() {
		  return ew;
		 }

		 public void setEw(float ew) {
		  this.ew = ew;
		 }

		 public float getS() {
		  return s;
		 }

		 public void setS(float s) {
		  this.s = s;
		 }
}  