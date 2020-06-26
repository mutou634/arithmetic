class Solution {
    // 不看解析不知道这么牛批的方法
    // 异或经常考，圈起来要考，只要说不占用额外内存的就警惕
    public int singleNumber(int[] nums) {
       // 异或 ⊕ 的特性
       // 0 异或 x  = x
       // x 异或 b = b
       // b 异或 b = 0
       int res = 0;
       for(int i:nums){
           res ^= i;
       }
       // 最后返回是落单的
        return res;
    }
}