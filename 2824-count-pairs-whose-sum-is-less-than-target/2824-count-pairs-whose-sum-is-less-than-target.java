class Solution {
    public int countPairs(List<Integer> nums, int target) {
        // List ko array mein convert aur sort karo
        Collections.sort(nums);
        
        int left = 0;
        int right = nums.size() - 1;
        int count = 0;
        
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            
            if (sum < target) {
                // 🔥 MAGIC: left ke saath, left+1 se lekar right tak
                // saare numbers ka sum < target hoga!
                count += (right - left);
                
                // Ab left ko aage badhao, aur bade numbers try karo
                left++;
            } 
            else {
                // Sum bada ya equal hai, right ko chhota karo
                right--;
            }
        }
        
        return count;
    }
}