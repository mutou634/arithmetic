class Solution {
    public int[] plusOne(int[] digits) {
        int count=0;
       for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
                digits[i]++;    //末尾不是9，不进位，直接加1结束
				return digits;
			} 
			digits[i] = 0;   //i位是9，进位，置为0
		}
        //全部进位则需要增加空间
		int[] temp = new int[digits.length + 1];
		temp[0] = 1;
		return temp;
    }
}