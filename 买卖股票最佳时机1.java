//���������������ҵ���������������������֣�Ҫ���һ�������ڵڶ������ֵ�ǰ��
//�ö�̬�滮˼�룬���������θ���max��min�����ٺ����Ѱ��
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1)
         return 0;
         int min=prices[0],max=0;
         //�������
         for(int i=0;i<prices.length;i++){
             max=Math.max(max,prices[i]-min);
             min=Math.min(min,prices[i]);
         }
         return max;
    }
}