class Solution {
    public int[] plusOne(int[] digits) {
        int count=0;
       for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
                digits[i]++;    //ĩβ����9������λ��ֱ�Ӽ�1����
				return digits;
			} 
			digits[i] = 0;   //iλ��9����λ����Ϊ0
		}
        //ȫ����λ����Ҫ���ӿռ�
		int[] temp = new int[digits.length + 1];
		temp[0] = 1;
		return temp;
    }
}