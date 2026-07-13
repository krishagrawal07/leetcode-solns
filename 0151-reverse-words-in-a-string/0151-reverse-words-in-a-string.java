class Solution {
    public String reverseWords(String s) {
        // Trim karo taaki leading/trailing spaces hat jaayein
        s = s.trim();
        
        int n = s.length();
        StringBuilder result = new StringBuilder();
        
        // right pointer - last character se start
        int right = n - 1;
        
        while (right >= 0) {
            
            // Step 1: Spaces skip karo (word ke pehle ke spaces)
            while (right >= 0 && s.charAt(right) == ' ') {
                right--;
            }
            
            // Step 2: Word ka end mark karo
            int wordEnd = right;
            
            // Step 3: Word ke start tak jao
            while (right >= 0 && s.charAt(right) != ' ') {
                right--;
            }
            
            // Step 4: Word ka start = right + 1
            int wordStart = right + 1;
            
            // Step 5: Word ko result mein add karo
            // Pehle se kuch hai toh space add karo
            if (result.length() > 0) {
                result.append(' ');
            }
            
            for (int i = wordStart; i <= wordEnd; i++) {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    }
}