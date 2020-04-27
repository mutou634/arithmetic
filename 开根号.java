class Solution {
    public int mySqrt(int x) {
        if(x==1) return 1;
        int left=0,right=x;
        while(right-left>1){
            int mid=(left+right)/2;
            if(x/mid<mid)
                right=mid;
            else
                left=mid;
        }
        return left;
    }
}