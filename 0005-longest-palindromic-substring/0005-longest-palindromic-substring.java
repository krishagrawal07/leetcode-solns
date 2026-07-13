class Solution {
    private int expand(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    public String longestPalindrome(String s) {
        int start=0,end=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            int len1=expand(s,i,i); //odd length
            int len2=expand(s,i,i+1); //even length
            int len=Math.max(len1,len2);

            if(len>(end-start+1)){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
}