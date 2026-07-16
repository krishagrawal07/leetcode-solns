class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        if (n == 0 || k == 0) return new int[0];
        
        // Use int[] as stack instead of Stack class - much faster
        int[] stack = new int[n];
        int top = -1;
        
        int[] nge = new int[n];
        nge[n - 1] = n;
        stack[++top] = n - 1;  // push
        
        // Build NGE from right to left
        for (int i = n - 2; i >= 0; i--) {
            // Pop smaller elements using int[] stack
            while (top >= 0 && arr[i] >= arr[stack[top]]) {
                top--;  // pop
            }
            nge[i] = (top == -1) ? n : stack[top];
            stack[++top] = i;  // push
        }
        
        int[] result = new int[n - k + 1];
        int j = 0;
        
        for (int i = 0; i <= n - k; i++) {
            if (j < i) j = i;
            
            // Jump via NGE while next greater is inside window
            while (nge[j] < i + k) {
                j = nge[j];
            }
            
            result[i] = arr[j];
        }
        
        return result;
    }
}