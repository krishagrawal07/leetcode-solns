class Solution {
    public int numIdenticalPairs(int[] nums) {
        //n= number of similar count and the forumla is n*(n-1)/2
        int res=0;
        int countarray[] = new int[101];
        for(int num:nums){
            countarray[num]++; //count array ka index 1 bdha do jisse harr number        ki frequency milegi index wise


        }
        for(int count:countarray){
            count=count*(count-1)/2;
            res+=count;

        }
        return res;
    }
}