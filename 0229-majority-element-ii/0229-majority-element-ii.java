class Solution {
    public List<Integer> majorityElement(int[] nums) {

        // Boyer-Moore Majority Vote Algorithm
        //Maximum 2 hi elements ho sakte hain (kyunki 3 × (n/3 + 1) > n)
        //Example: [1,1,1,2,2,2,3,3,3] mein koi n/3 se zyada nahi
         //[1,1,1,1,2,2,2,2,3] mein 1 aur 2 dono > n/3 (9/3=3)

        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        
        // Step 1: Find candidates using Boyer-Moore (2 candidates possible)
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;
        
        for (int num : nums) {
            if (count1 > 0 && num == candidate1) {
                count1++;
            } else if (count2 > 0 && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        // Step 2: Verify candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }
        
        int mini = n / 3 + 1;
        if (count1 >= mini) result.add(candidate1);
        if (count2 >= mini) result.add(candidate2);
        
        return result;
    }
}