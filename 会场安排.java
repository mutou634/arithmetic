package arithmeticDemo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MeetingPlaceProblem {
    private static Integer endTime[];//����ʱ��
    private static Integer[] startTime;//��ʼʱ��
    private static int count = 1;//�᳡
    private static Integer end;//��̬����ʱ��
    
    public static void input() {
    	System.out.println("�����밲�Ż��:");
    	Scanner in=new Scanner(System.in);
    	int n=in.nextInt();
    	endTime=new Integer[n];
    	startTime=new Integer[n];
    	System.out.println("��������ÿ����Ŀ�ʼ������ʱ�䣺");
    	for(int i=0;i<n;i++) {
    		startTime[i]=in.nextInt();
    		endTime[i]=in.nextInt();
    	}
    	in.close();
    	quickSort(startTime,0,n-1);
    }
    public static void quickSort(Integer[] startTime2,int low,int high){
        int i,j,temp,temp2,t,t2;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        temp = startTime2[low];
        temp2=endTime[low];
        while (i<j) {
            while (temp<=startTime2[j]&&i<j) {
                j--;
            }
            while (temp>=startTime2[i]&&i<j) {
                i++;
            }
            if (i<j) {
                t = startTime2[j];
                startTime2[j] = startTime2[i];
                startTime2[i] = t;
                t2=endTime[j];
                endTime[j]=endTime[i];
                endTime[i]=t2;
            } 
        }
        //����׼Ϊ��i��j���λ�õ����ֽ���
         startTime2[low] = startTime2[i];
         startTime2[i] = temp;
         endTime[low]=endTime[i];
         endTime[i]=temp2;
        quickSort(startTime2, low, j-1);
        quickSort(startTime2, j+1, high);
    }
    private static String transform(Integer integer){
        for (int i=0;i<endTime.length;i++){
            if(integer==endTime[i])
                return "�"+(i+1)+": ";
        }
        return "";
    }
    public static void main(String[] args) {
        input();
        List<Integer> listEnd = new ArrayList<Integer>();//������ʱ��װ������
        for (int i = 0; i < endTime.length; i++) {
            listEnd.add(endTime[i]);
        }
        List<Integer> listStart = new ArrayList<Integer>();//����ʼʱ��װ������
        for (int i = 0; i < startTime.length; i++) {
            listStart.add(startTime[i]);
        }
           while(listStart.size()>0) {
               end = listEnd.get(0);
               System.out.println("�᳡"+count+": ");//���ٻ᳡
               System.out.println(transform(listEnd.get(0))+"��ʼʱ�䣺"+listStart.get(0) + "  ����ʱ�䣺"+ listEnd.get(0));
               for (int i = 1; i < listStart.size(); i++) {
                   if (listStart.get(i) > end) {
                       System.out.println(transform(listEnd.get(i))+"��ʼʱ�䣺"+listStart.get(i) + "  ����ʱ�䣺" + listEnd.get(i));
                       end = listEnd.get(i);
                       listEnd.remove(i);//�Ƴ��Ѱ��źû᳡�Ļ
                       listStart.remove(i);
                       i--;//ʹ�±걣�ֲ��䣬ȷ��ÿһ�����ݶ����ʵ�
                   }
               }
               listEnd.remove(0);
               listStart.remove(0);
               count++;
           }
 
    }
}