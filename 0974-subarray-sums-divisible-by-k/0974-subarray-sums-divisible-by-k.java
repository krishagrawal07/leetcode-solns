class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1); //initialise 0 ki frequency 1
        int count=0;
        int prefsum=0;
        for (int num:nums){
            prefsum+=num;
             int rem = ((prefsum % k) + k) % k; // handle negative remainders
            
            if(map.containsKey(rem)){
                count+=map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);

            
        }
        return count;
    }
}