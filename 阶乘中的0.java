class Solution {
    public int trailingZeroes(int n) {
        //经过总结计算阶乘中的5,
         int count=0;
         while(n>=5){
             //不断除以 5, 是因为每间隔 5 个数有一个数可以被 5 整           
             //除, 然后在这些可被 5 整除的数中, 每间隔 5 个数又有一个可以被 25 整除, 故要再除一次,直                  //到结果为 0, 表示没有能继续被 5 整除的数了.
             count+=n/5;
             n/=5;
         }
         return count;
    }
}