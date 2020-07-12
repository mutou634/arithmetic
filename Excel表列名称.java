class Solution {
    public String convertToTitle(int n) {
        //对不能转换的数进行排除
         if (n <= 0) {
              return "";
          }
           StringBuilder sb = new StringBuilder();
           while (n > 0) {
              //给定映射中并无0；-1就是为了使【0~25】对映A~Z
              n--;
              sb.append((char) (n % 26 + 'A'));
              n =n / 26;
         }
         return sb.reverse().toString();
    } 
}