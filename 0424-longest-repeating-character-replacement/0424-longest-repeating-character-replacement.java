class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];           // sirf 'A'-'Z' ke liye
        int left = 0;
        int maxCount = 0;                    // current window mein sabse zyada baar aane wala char
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            
            // maxCount sirf tabhi update hota hai jab koi char aur zyada baar aaye
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);

            // Agar window invalid hai: (window size - maxCount) > k
            while (right - left + 1 - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Ab window valid hai, result update karo
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}