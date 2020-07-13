class Solution {
    public int titleToNumber(String s) {
         int sum=0;
         for(int i=s.length()-1,j=1;i>=0;i--,j*=26)
              sum+=(s.charAt(i)-64)*j;
              return sum;
    }
}