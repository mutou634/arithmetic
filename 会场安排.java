package arithmeticDemo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MeetingPlaceProblem {
    private static Integer endTime[];//结束时间
    private static Integer[] startTime;//开始时间
    private static int count = 1;//会场
    private static Integer end;//动态结束时间
    
    public static void input() {
    	System.out.println("请输入安排活动数:");
    	Scanner in=new Scanner(System.in);
    	int n=in.nextInt();
    	endTime=new Integer[n];
    	startTime=new Integer[n];
    	System.out.println("依次输入每个活动的开始、结束时间：");
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
        //将基准为与i和j相等位置的数字交换
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
                return "活动"+(i+1)+": ";
        }
        return "";
    }
    public static void main(String[] args) {
        input();
        List<Integer> listEnd = new ArrayList<Integer>();//将结束时间装进集合
        for (int i = 0; i < endTime.length; i++) {
            listEnd.add(endTime[i]);
        }
        List<Integer> listStart = new ArrayList<Integer>();//将开始时间装进集合
        for (int i = 0; i < startTime.length; i++) {
            listStart.add(startTime[i]);
        }
           while(listStart.size()>0) {
               end = listEnd.get(0);
               System.out.println("会场"+count+": ");//开辟会场
               System.out.println(transform(listEnd.get(0))+"开始时间："+listStart.get(0) + "  结束时间："+ listEnd.get(0));
               for (int i = 1; i < listStart.size(); i++) {
                   if (listStart.get(i) > end) {
                       System.out.println(transform(listEnd.get(i))+"开始时间："+listStart.get(i) + "  结束时间：" + listEnd.get(i));
                       end = listEnd.get(i);
                       listEnd.remove(i);//移除已安排好会场的活动
                       listStart.remove(i);
                       i--;//使下标保持不变，确保每一个数据都访问到
                   }
               }
               listEnd.remove(0);
               listStart.remove(0);
               count++;
           }
 
    }
}