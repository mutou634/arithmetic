class Solution {
    public String convertToTitle(int n) {
        //�Բ���ת�����������ų�
         if (n <= 0) {
              return "";
          }
           StringBuilder sb = new StringBuilder();
           while (n > 0) {
              //����ӳ���в���0��-1����Ϊ��ʹ��0~25����ӳA~Z
              n--;
              sb.append((char) (n % 26 + 'A'));
              n =n / 26;
         }
         return sb.reverse().toString();
    } 
}