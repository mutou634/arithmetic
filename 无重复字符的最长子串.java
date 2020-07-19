class Solution {
    public int lengthOfLongestSubstring(String s) {
          int size,i=0,j,k,max=0;
          char[] s1=s.toCharArray();
          size=s.length();
          for(j=0;j<size;j++){
              for(k=i;k<j;k++){
                  if(s1[k]==s1[j]){
                  i=k+1;
                  break;
                  }
              }
              if(j-i+1>max)
                  max=j-i+1;
          } 
          return max;
    }
}