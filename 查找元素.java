class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0;
        while(nums[i]<target&&i<nums.length-1){ //û�ҵ��ͼ�����ȥ���賤��Ϊ7�����±�6ֹͣ�����һ��Ԫ��δ��
              i++;
        }
        return nums[i]<target?i+1:i;   //1�������һ��Ԫ�أ���С�ͼ�1����ȡ�����ֱ�����
    }                                  //2����;ֹͣ(Ҫô�ҵ��ˣ�Ҫô�͹�������)����ȵġ����ڵ�                                          //nums[i]�����i(��ʱ�Ͳ������С�ڵ����)
}