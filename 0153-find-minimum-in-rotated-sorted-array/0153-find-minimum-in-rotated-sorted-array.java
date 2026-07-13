class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {          // ← "<" not "<=" (kyunki min dhoondhna hai)
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                // Left sorted, min right mein
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // Right sorted, min left mein (mid bhi ho sakta hai!)
                right = mid;            // ← mid ko mat chhodo!
            } else {
                // Equal, ek kam kar do
                right--;
            }
        }
        
        return nums[left];   // left == right == min
    }
}