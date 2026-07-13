class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int sq=n*n;
        int set[] = new int[sq+1]; //+1 kyuki elements store kerne he se sab so index se ek sath jada number total number store kra dega

        int currsum=0;
        int ans[] = new int[2]; // size 2

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(set[grid[i][j]] != 0){
                    ans[0] = grid[i][j];
                }
                else{
                    set[grid[i][j]]=1;
                    currsum+=grid[i][j];
                }
            }
        }
        int totalsum=sq*(sq+1)/2;
        ans[1]=totalsum-currsum;
        return ans;

    }
}