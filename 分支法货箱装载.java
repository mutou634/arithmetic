package arithmeticDemo;

public class Container {
		 public static void main(String[] args) {
		  // n个货箱
		  int n = 3;
		  // 第一艘船的载重量
		  float c1 = 50;
		  // 第二艘船的载重量
		  float c2 = 50;
		  // 货箱质量数组
		  float[] w = { 0, 10, 40, 40 };

		  // 测试例子
		  Container bfis = new Container(n, c1, c2, w);
		  // 所有货箱的重量之和
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

		 private int n; // n个货箱
		 private float c1; // 第一艘船的载重量
		 private float c2; // 第二艘船的载重量
		 private float bestw; // 第一艘船的最大装载
		 private float ew = 0; // 当前船的装载量
		 private float[] w; // 货箱质量数组
		 private float s = 0; // 所有货箱的重量之和
		 private MyQueue mq = new MyQueue(); // FIFO队列

		 /**
		  * 构造方法
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
		  * 最优装载值
		  */
		 public float maxLoading(float c) {
		  mq.put(new Float(-1)); // 初始化结点队列，标记分层
		  int i = 1; // E-结点的层
		  ew = 0; // 当前船的装载量
		  bestw = 0; // 目前的最优值

		  while (!mq.empty()) { // 搜索子集空间树
		   if (ew + w[i] <= c) { // 检查E-结点的左孩子，货箱i是否可以装载
		    addLiveNode(ew + w[i], i); // 货箱i可以装载
		   }

		   addLiveNode(ew, i); // 右孩子总是可行的，不装载货物i

		   ew = (Float) mq.get(); // 取下一个结点

		   if (ew == -1) { // 到达层的尾部
		    if (mq.empty()) {
		     return bestw;
		    }
		    mq.put(new Float(-1));
		    ew = (Float) mq.get(); // 取下一个结点
		    i++; // ew的层
		   }
		  }
		  return bestw;
		 }
		 public void addLiveNode(float wt, int i) {
		  if (i == n) { // 是叶子
		   if (wt > bestw) {
		    bestw = wt;
		   }
		  } else { // 不是叶子
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