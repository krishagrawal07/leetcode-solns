class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);

        int left = (n - 1) / 2; // end of first half
        int right = n - 1;      // end of second half

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = temp[left--];
            } else {
                nums[i] = temp[right--];
            }
        }
    }
}