class Solution {
    public boolean check(int[] arr) {
        int n = arr.length,count=0;

        for(int i=1;i<n;i++){

            if(arr[i-1]>arr[i]){
                count++;
            }
        }

        if(arr[n-1]>arr[0]) count++;

        return count<=1;
    }
}