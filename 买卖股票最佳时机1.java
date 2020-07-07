//问题描述，即：找到数组中两个相差最大的数字，要求第一个数字在第二个数字的前面
//用动态规划思想，从左到右依次更新max，min，减少后面的寻找
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1)
         return 0;
         int min=prices[0],max=0;
         //容易理解
         for(int i=0;i<prices.length;i++){
             max=Math.max(max,prices[i]-min);
             min=Math.min(min,prices[i]);
         }
         return max;
    }
}