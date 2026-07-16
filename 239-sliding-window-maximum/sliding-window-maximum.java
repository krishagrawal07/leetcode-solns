class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }
        
        int n = arr.length;
        int[] result = new int[n - k + 1];
        
        // Step 1: Build Next Greater Element (NGE) array
        // nge[i] = index of next element to the right that is > arr[i]
        // If no such element exists, nge[i] = n (out of bounds)
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        
        nge[n - 1] = n;  // no greater element to the right
        st.push(n - 1);
        
        for (int i = n - 2; i >= 0; i--) {
            // Pop all elements smaller than or equal to current
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        
        // Step 2: For each window, jump via NGE to find max
        int j = 0;
        for (int i = 0; i <= n - k; i++) {  // FIXED: <= not <
            // Start from current window start or continue from previous j
            // Ensure j is at least at window start
            if (j < i) {
                j = i;
            }
            
            // Jump forward while next greater is still inside window
            while (nge[j] < i + k) {
                j = nge[j];
            }
            
            // Now arr[j] is the maximum for window [i, i+k)
            result[i] = arr[j];
        }
        
        return result;
    }
}