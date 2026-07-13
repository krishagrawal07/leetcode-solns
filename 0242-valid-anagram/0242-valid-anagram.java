class Solution {
    public boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) 
            return false;

        // Initialize a frequency array to store character counts
        int[] freq = new int[26];

        // Count frequency of each character in str1
        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i) - 'a']++;  // Increment frequency for each character in str1
        }

        // Decrement frequency for each character in str2
        for (int i = 0; i < str2.length(); i++) {
            freq[str2.charAt(i) - 'a']--;  // Decrement frequency for each character in str2
        }

        // Check if all frequencies are zero, meaning both strings have the same characters
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0)  // If any frequency is non-zero, they are not anagrams
                return false;
        }

        return true;  // The strings are anagrams
    }
}