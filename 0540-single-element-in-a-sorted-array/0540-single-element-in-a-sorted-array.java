class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Ensure mid is even (start of a potential pair)
            if (mid % 2 == 1) {
                mid--;
            }
            
            // Compare with the next element
            if (nums[mid] == nums[mid + 1]) {
                // Pair is intact, single element is to the right
                left = mid + 2;
            } else {
                // Pair is broken, single element is at mid or to the left
                right = mid;
            }
        }
        
        return nums[left];
    }
}