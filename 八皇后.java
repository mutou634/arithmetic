package arithmeticDemo;
public class Queen {
    int queens=8;
    //�����������ڱ���ʺ�ڷ�λ�õĽ��
    int[] array=new int[queens];
    static int count=0;
    public static void main(String[] args) {
        Queen e = new Queen();
        e.check(0);
        System.out.printf("һ����%d�нⷨ��",count);
    }
    /**
     * �ڷŻʺ�
     * @param n
     */
    private void check(int n){
        if(n==queens){//��n����8ʱ˵��8���ʺ��Ѿ��ź�
            print();
            return;
        }
        //���η���ʺ󣬲��ж��Ƿ��ͻ
        for (int i = 0; i < queens; i++) {
            //����ǰ����ʺ�n�ŵ����еĵ�i��
            array[n]=i;
            //�жϵ�ǰλ���Ƿ��ͻ
            if(judge(n)){//����ͻ
                //���ŷ�n+1���ʺ�
                check(n+1);
            }
        }
    }
    //�ж��Ƿ��ͻ��1���в��ÿ��ǣ�ͬ�� 2��б���жϣ���ͬ�������о���б�ʲ���Ϊ1
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                    return false;
            }
        }
        return true;
    }
    /**
     * ��ӡ�ʺ�İڷŽ��
     */
    public void print(){
        count ++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}