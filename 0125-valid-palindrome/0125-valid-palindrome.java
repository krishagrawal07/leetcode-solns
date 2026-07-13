class Solution {
    public boolean isPalindrome(String s) {
        // Line 1: Two pointers initialize karo
        // left = 0 (string ke start se)
        // right = s.length() - 1 (string ke end se)
        int left = 0;
        int right = s.length() - 1;

        // Line 2: Jab tak left pointer right pointer se chhota hai
        // Matlab dono pointers ne abhi tak milna nahi hai center mein
        while (left < right) {

            // Line 3: Left side se non-alphanumeric characters skip karo
            // Character.isLetterOrDigit(char) -> True agar character letter ya digit ho
            // Jab tak left < right hai aur s.charAt(left) alphanumeric nahi hai
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;  // left pointer ko ek step aage badhao
            }

            // Line 4: Right side se non-alphanumeric characters skip karo
            // Same logic right side ke liye
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;  // right pointer ko ek step peeche le aao
            }

            // Line 5: Ab dono pointers valid alphanumeric characters pe hain
            // Unhe lowercase mein convert karke compare karo
            // Character.toLowerCase(char) -> character ko lowercase mein convert karta hai
            // Case insensitive comparison ke liye
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;  // Match nahi hua -> Palindrome nahi hai
            }

            // Line 6: Match ho gaya! Dono pointers ko center ki taraf le aao
            left++;   // left pointer aage badhega
            right--;  // right pointer peeche aayega
        }

        // Line 7: Loop complete ho gaya bina false return kiye
        // Matlab sab characters match kar gaye
        return true;  // Palindrome hai!
    }
}