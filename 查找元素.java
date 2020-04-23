class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0;
        while(nums[i]<target&&i<nums.length-1){ //没找到就继续下去，设长度为7，到下标6停止，最后一个元素未比
              i++;
        }
        return nums[i]<target?i+1:i;   //1：比最后一个元素，还小就加1，相等、大于直接输出
    }                                  //2：中途停止(要么找到了，要么就过界限了)，相等的、大于的                                          //nums[i]，输出i(此时就不会出现小于的情况)
}