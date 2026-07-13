class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Stores <element, next greater element>
        HashMap<Integer, Integer> map = new HashMap<>();

        // Monotonic decreasing stack
        Stack<Integer> st = new Stack<>();

        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {

            // Remove all smaller or equal elements
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            // If stack is empty, no greater element exists
            if (st.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                // Top of stack is the next greater element
                map.put(nums2[i], st.peek());
            }

            // Push current element for future comparisons
            st.push(nums2[i]);
        }

        // Build answer for nums1
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}