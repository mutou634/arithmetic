package demo;
public class RandomizedSelect {
	private static int select(int[] a,int l,int r,int k){
	    if(r - l < 75){
	        insertSort(a, l, r);    //�ÿ��������������
	        return a[l + k - 1];
	    }
	    int group = (r-l+5)/5;   //���飬��5��Ϊ�˱�֤�����5λ��Ҳ����
	    for(int i = 0;i<group;i++){   //�����������
	        int left = l+5*i;
	        int right = (l + i * 5 + 4) > r ? r : l + i * 5 + 4;  //��������ұ߽�����ұ߽縳ֵ
	        int mid = (left+right)/2;
	        insertSort(a, left, right);
	        swap(a, l + i, mid);     // ������λ��������ǰ�漸��Ԫ�� 
	    }
	    int pivot = select(a,l,l+group-1,(group+1)/2);  //�ҳ���λ������λ��
	    int p = partition(a,l,r,pivot);    //����λ������λ����Ϊ��׼��λ�ã���λ���������е���ȷλ�ã�
	    int leftNum = p - l;       //leftNum������¼��׼λ�õ�ǰ�ߵ�Ԫ�ظ���
	    if (k == leftNum + 1)
	        return a[p];
	    else if (k <= leftNum)
	        return select(a, l, p - 1, k);
	    else                    //��k�ڻ�׼λ�ӵĺ�ߣ���Ҫ�ӻ�׼λ�õĺ�����𣬼��ڣ�k - leftNum - 1����
	        return select(a, p + 1, r, k - leftNum - 1);
	}
//������ŵķ����ҵ�һ��Ԫ���������е���ȷλ��
	private static int partition(int[] a,int l,int r,int pivot){   //����������ʱ��ѡ���partition����
	    int i = l;
	    int j = r;
	    while(true){
	        while(a[i] <= pivot && i < r)
	            ++i;   //iһֱ����ƶ���ֱ������a[i]>pivot
	        while(a[j] > pivot)
	            --j;   //jһֱ��ǰ�ƶ���ֱ������a[j]<pivot
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
//��������
	private static void insertSort(int[] a,int l,int r){
		if(l < r){
			int q = partitionS(a,l,r);
			insertSort(a,l,q-1);
			insertSort(a,q+1,r);
		}
}
	private static int partitionS(int[] a,int l,int r){
	    int i = l;
	    int j = r;
	    int pivot = a[l];
	    int temp;
	    while(true){
	        while(a[i] <= pivot && i < r)
	            ++i;
	        while(a[j] > pivot)
	            --j;   //jһֱ��ǰ�ƶ���ֱ������a[j]<pivot
	        if(i >= j) break;
	        temp = a[i];      //����a[i]��a[j]
	        a[i] = a[j];
	        a[j] = temp;
	    }
	    a[l] = a[j];
	    a[j] = pivot;
	    return j;
	}
	public static void main(String[] args) {
		int a[]= {3,1,7,6,5,9,8,2,0,4,13,11,17,16,15,19,18,12,10,14,23,21,27,26,25,29,28,22,20,24,33,31,37,36,35,39,38,32,30,34,43,41,47,46,45,49,48,42,40,44,53,51,57,56,55,59,58,52,50,54,63,61,67,66,65,69,68,62,60,64,73,71,77,76,75,79,78,72,70,74,
        };
		int i=select(a,0,79,60);
		System.out.println(i);
	}
}