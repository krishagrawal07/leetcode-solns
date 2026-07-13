class Solution {
    public boolean checkIfPangram(String s) {
        boolean[] arr=new boolean[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']=true;
        }

        for(boolean curr:arr){
            if(!curr){
                return false;
            }
        }
        return true;
    }
}