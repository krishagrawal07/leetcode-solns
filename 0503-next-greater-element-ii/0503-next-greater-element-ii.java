class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        // Default answer sabke liye -1 hoga
        Arrays.fill(ans, -1);

        Stack<Integer> st = new Stack<>();

        // Array ko 2 baar traverse karenge (circular array ke liye)
        for (int i = 2 * n - 1; i >= 0; i--) {

            // Circular index
            int index = i % n;

            // Current element se chhote ya equal elements hata do
            while (!st.isEmpty() && st.peek() <= nums[index]) {
                st.pop();
            }

            // Sirf pehli baar (actual indices) answer fill karna hai
            if (i < n && !st.isEmpty()) {
                ans[index] = st.peek();
            }

            // Current element stack me push karo
            st.push(nums[index]);
        }

        return ans;
    }
}