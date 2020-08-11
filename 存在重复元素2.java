class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i])<=k)//重复元素距离小于k
                    return true;
                else
                    map.put(nums[i],i);//否则重新归置重复元素的位置
            }else
                map.put(nums[i],i);
        }
        return false;

    }
}