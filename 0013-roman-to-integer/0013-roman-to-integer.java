class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        int prev = 0;  // Pehle se koi "previous" nahi hai
        
        // Right se left traverse karo
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = value(s.charAt(i));
            
            // Agar curr < prev → yeh subtraction part hai (e.g., I in IV)
            // Agar curr >= prev → normal addition
            if (curr < prev) {
                ans -= curr;
            } else {
                ans += curr;
            }
            
            prev = curr;  // Current ko next iteration ke liye previous banao
        }
        
        return ans;
    }
    
    // Helper method — switch se fast hota hai HashMap se
    private int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}