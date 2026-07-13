class Solution {
    public boolean isValid(String s) {

        // Stack to store opening brackets
        Stack<Character> st = new Stack<>();

        // Traverse every character
        for (char ch : s.toCharArray()) {

            // If opening bracket, push into stack
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {

                // Closing bracket without opening bracket
                if (st.isEmpty())
                    return false;

                // Remove last opening bracket
                char top = st.pop();

                // Check if brackets match
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Stack should be empty if all brackets matched
        return st.isEmpty();
    }
}