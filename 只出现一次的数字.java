class Solution {
    // ����������֪����ôţ���ķ���
    // ��򾭳�����Ȧ����Ҫ����ֻҪ˵��ռ�ö����ڴ�ľ;���
    public int singleNumber(int[] nums) {
       // ��� �� ������
       // 0 ��� x  = x
       // x ��� b = b
       // b ��� b = 0
       int res = 0;
       for(int i:nums){
           res ^= i;
       }
       // ��󷵻����䵥��
        return res;
    }
}