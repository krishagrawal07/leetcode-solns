class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        
        // Step 1: Leading whitespace skip
        while (i < n && s.charAt(i) == ' ') i++;
        if (i >= n) return 0;  // Agar sirf spaces thi toh 0
        
        // Step 2: Sign check (+ ya -)
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        
        // Step 3: Digits parse karo
        int result = 0;
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';
            
            // Step 4: OVERFLOW CHECK (yeh sabse important hai)
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        return sign * result;
    }
}