class Solution {
    public int maxProfit(int[] prices) {
       int minday=prices[0];
       int maxday=0;
        for(int i=0;i<prices.length;i++){
            if(minday>prices[i]){
                minday=prices[i];
            }
            int profit =prices[i]-minday;
            if(profit>maxday){
                maxday=profit;
            }
        }
        return maxday;
    }
}