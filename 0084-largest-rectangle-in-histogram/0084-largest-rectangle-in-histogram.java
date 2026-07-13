class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        // Stack stores indices of bars
        Stack<Integer> st = new Stack<>();

        int maxArea = 0;

        // Traverse one extra time (i == n) to empty the stack
        for (int i = 0; i <= n; i++) {

            // At i == n, take current height as 0
            int currHeight = (i == n) ? 0 : heights[i];

            // Current bar is smaller, so calculate area
            while (!st.isEmpty() && heights[st.peek()] > currHeight) {

                // Height of rectangle
                int height = heights[st.pop()];

                // Left boundary
                int leftSmaller = st.isEmpty() ? -1 : st.peek();

                // Width of rectangle
                int width = i - leftSmaller - 1;

                // Update maximum area
                maxArea = Math.max(maxArea, height * width);
            }

            // Push current index
            st.push(i);
        }

        return maxArea;
    }
}