class Solution {
  public int strStr(String haystack, String needle) {
    int L = needle.length(), n = haystack.length();
    if (L == 0) return 0;     //子串为空时，返回0
    //pn：主串中对比到的下标
    int pn = 0;
    //第一层while循环，用作第一次对比失败进行下一次循环
    while (pn < n - L + 1) {
      //在主串的剩余元素中找到与子串第一个元素相同的
      while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;
      //currLen、pL匹配长度
      int currLen = 0, pL = 0;
      while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
        ++pn;
        ++pL;
        ++currLen;
      }

      if (currLen == L) return pn - L;
      //匹配失败继续寻找
      pn = pn - currLen + 1;
    }
    return -1;
  }
}