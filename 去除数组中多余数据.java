class Solution {
    public int removeDuplicates(int[] nums) {
        int pass=0,pass2=1;
        while(pass2<nums.length){
            if(nums[pass]==nums[pass2]){
                pass2++;
            }
            else{
                pass++;
                nums[pass]=nums[pass2];
                pass2++;
            }
        }
        return pass+1;
    }
}