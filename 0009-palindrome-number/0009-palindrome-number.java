class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int reverse=0,num=x;

        while(num!=0){
            int digit = num%10;
            reverse = reverse*10+digit;
            num/=10;
        }

        if(reverse==x){
            return true;
        }
        return false;
    }
}