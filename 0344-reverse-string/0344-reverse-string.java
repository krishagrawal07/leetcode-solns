class Solution {
    public void reverseString(char[] s) {
        int left = 0;              // Start se
        int right = s.length - 1;  // End se
        
        while (left < right) {     // Jab tak cross na ho jayein
            
            // Step 1: Swap characters
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            // Step 2: Pointers ko center ki taraf le aao
            left++;
            right--;
        }
        // Kuch return nahi karna, in-place modify hua hai
    }
}