class Solution {
  public int strStr(String haystack, String needle) {
    int L = needle.length(), n = haystack.length();
    if (L == 0) return 0;     //�Ӵ�Ϊ��ʱ������0
    //pn�������жԱȵ����±�
    int pn = 0;
    //��һ��whileѭ����������һ�ζԱ�ʧ�ܽ�����һ��ѭ��
    while (pn < n - L + 1) {
      //��������ʣ��Ԫ�����ҵ����Ӵ���һ��Ԫ����ͬ��
      while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;
      //currLen��pLƥ�䳤��
      int currLen = 0, pL = 0;
      while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
        ++pn;
        ++pL;
        ++currLen;
      }

      if (currLen == L) return pn - L;
      //ƥ��ʧ�ܼ���Ѱ��
      pn = pn - currLen + 1;
    }
    return -1;
  }
}