class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxEnding = nums[0];
        int maxSum = nums[0];

        int minEnding = nums[0];
        int minSum = nums[0];

        int total = nums[0];
        for (int i = 1; i < nums.length; i++) {

            total += nums[i];
            // Maximum Kadane
            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            maxSum = Math.max(maxSum, maxEnding);

            // Minimum Kadane
            minEnding = Math.min(nums[i], minEnding + nums[i]);
            minSum = Math.min(minSum, minEnding);
        }
        // All numbers are negative
        if (maxSum < 0)
            return maxSum;

        return Math.max(maxSum, total - minSum);

    }
}