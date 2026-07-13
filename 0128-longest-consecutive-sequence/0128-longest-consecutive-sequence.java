import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        int ans = 0;
        // ✅ Set se iterate karo — duplicates automatically handle ho jayenge
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                int current = num + 1;
                
                while (set.contains(current)) {
                    count++;
                    current++;
                }
                
                ans = Math.max(ans, count);
            }
        }
        
        return ans;
    }
}