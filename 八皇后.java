public class Queen {
    public static int num = 0;//�ۼƷ���
    public static final int MAXQUEEN = 8;
    public static int[] cols = new int[MAXQUEEN];   //�������飬��ʾ8�����ӻʺ�ڷŵ�λ��
 
 
    /**
     * @param n ��ʾ���n�еĻʺ�
     * */
    public void getCount(int n){
        boolean[] rows = new boolean[MAXQUEEN];
 
        for(int i = 0;i < n;i++){
            rows[cols[i]] = true;
 
            int d = n - i;  //�����ֵ
 
            //��б����
            if(cols[i] - d >= 0){
                rows[cols[i]- d] = true;
            }
 
            //��б����
            if(cols[i] + d <= (MAXQUEEN - 1)){
                rows[cols[i] + d] = true;
            }
        }
 
        for(int i = 0;i < MAXQUEEN;i++){
            if(rows[i]){
                continue;
            }
            cols[n] = i;
 
            if(n < MAXQUEEN - 1){
                getCount(n + 1);
            }else{
                //�ҵ�һ�������ķ���
                num++;
                printQueen();
            }
        }
    }
 
    public void printQueen(){
        System.out.println("��" + num + "�ַ���");
        for(int i = 0;i < MAXQUEEN;i++){
            for(int j = 0;j < MAXQUEEN;j++){
                if(i == cols[j])
                    System.out.print("0 ");
                else
                    System.out.print("+ ");
            }
            System.out.println();
        }
    }
 
    public static void main(String[] args){
        Queen q = new Queen();
        q.getCount(0);
    }
 
}