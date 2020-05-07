package demo;
public class RandomizedSelect {
	private static int select(int[] a,int l,int r,int k){
	    if(r - l < 75){
	        insertSort(a, l, r);    //用快速排序进行排序
	        return a[l + k - 1];
	    }
	    int group = (r-l+5)/5;
	    for(int i = 0;i<group;i++){
	        int left = l+5*i;
	        int right = (l + i * 5 + 4) > r ? r : l + i * 5 + 4;  //如果超出右边界就用右边界赋值
	        int mid = (left+right)/2;
	        insertSort(a, left, right);
	        swap(a, l + i, mid);     // 将各组中位数与前i个 
	    }
	    int pivot = select(a,l,l+group-1,(group+1)/2);  //找出中位数的中位数
	    int p = partition(a,l,r,pivot);    //用中位数的中位数作为基准的位置
	    int leftNum = p - l;       //leftNum用来记录基准位置的前边的元素个数
	    if (k == leftNum + 1)
	        return a[p];
	    else if (k <= leftNum)
	        return select(a, l, p - 1, k);
	    else                    //若k在基准位子的后边，则要从基准位置的后边数起，即第（k - leftNum - 1）个
	        return select(a, p + 1, r, k - leftNum - 1);
	}
	private static int partition(int[] a,int l,int r,int pivot){   //适用于线性时间选择的partition方法
	    int i = l;
	    int j = r;
	    while(true){
	        while(a[i] <= pivot && i < r)
	            ++i;   //i一直向后移动，直到出现a[i]>pivot
	        while(a[j] > pivot)
	            --j;   //j一直向前移动，直到出现a[j]<pivot
	        if(i >= j) break;
	        swap(a,i,j);
	    }
	    a[l] = a[j];
	    a[j] = pivot;
	    return j;
	}
	private static void swap(int[] a,int i,int j){
	    int temp = a[i];
	    a[i] = a[j];
	    a[j] = temp;
	}
	//快速排序
	private static int[] insertSort(int[] a,int l,int r){
		if(l < r){
			int q = partitionS(a,l,r);
			insertSort(a,l,q-1);
			insertSort(a,q+1,r);
		}
		return a;
	}
	private static int partitionS(int[] a,int l,int r){
	    int i = l;
	    int j = r;
	    int pivot = a[l];
	    int temp;
	    //System.out.println("开始时pivot="+pivot); //查看开始时的pivot，非必要
	    while(true){
	        while(a[i] <= pivot && i < r)
	            ++i;   //i一直向后移动，直到出现a[i]>pivot
	       // System.out.println("i="+i); //查看当前的i，非必要
	        while(a[j] > pivot)
	            --j;   //j一直向前移动，直到出现a[j]<pivot
	       // System.out.println("j="+j); //查看当前的j，非必要
	        if(i >= j) break;
	        temp = a[i];      //交换a[i]和a[j]
	        a[i] = a[j];
	        a[j] = temp;
	       // System.out.print("中间过程的数组：");
	        for(int m:a)
	            System.out.print(m+" ");         //输出每次更改为止后的数组，非必要
	       // System.out.println();
	    }
	    a[l] = a[j];
	    a[j] = pivot;
	   // System.out.println("结束时pivot="+pivot);  //查看循环结束时的pivot，非必要
	    //System.out.print("Partition结束后的数组：");
	    //for(int m:a)
	        //System.out.print(m+" ");            //输出Partition结束后的数组，非必要
	    //System.out.println();
	    return j;
	}
	public static void main(String[] args) {
		int a[]=new a[80];
		a[80]= {3,1,7,6,5,9,8,2,0,4,13,11,17,16,15,19,18,12,10,14,23,21,27,26,25,29,28,22,20,24,33,31,37,36,35,39,38,32,30,34,43,41,47,46,45,49,48,42,40,44,53,51,57,56,55,59,58,52,50,54,63,61,67,66,65,69,68,62,60,64,73,71,77,76,75,79,78,72,70,74,
        };
		
	}
}