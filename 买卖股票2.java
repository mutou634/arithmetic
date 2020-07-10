class Solution {
    public int maxProfit(int[] prices) {
        //Ì°ÐÄËã·¨
        int all=0;
        for(int i=0;i<prices.length-1;i++){
            int pass=prices[i+1]-prices[i];
            if(pass>0) 
               all+=pass;
        }
        return all;
    }
}