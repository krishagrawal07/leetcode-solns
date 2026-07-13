class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        // Step 1: Find pivot (first index from right where nums[i] < nums[i+1])
        int first = -1;
        for (int i = n - 2; i >= 0; i--) { 
            if (nums[i] < nums[i + 1]) {
                first = i;
                break;                          
            }
        }
        
        // Step 2: If no pivot found, array is in descending order
        // Next permutation = reverse (smallest permutation)
        if (first == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        
        // Step 3: Find smallest element > nums[first] from the right
        int swapIdx = first;
        for (int j = n - 1; j > first; j--) {  
            if (nums[j] > nums[first]) {
                swapIdx = j;
                break;
            }
        }
        
        // Step 4: Swap pivot and swapIdx
        int temp = nums[first];
        nums[first] = nums[swapIdx];
        nums[swapIdx] = temp;
        
        // Step 5: Reverse the suffix (first+1 to end)
        reverse(nums, first + 1, n - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}