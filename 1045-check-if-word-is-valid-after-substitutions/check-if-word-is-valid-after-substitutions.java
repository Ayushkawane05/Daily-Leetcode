class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == 'a') {
                st.push(ch);
            } 
            else if (ch == 'b') {
                if (st.isEmpty() || st.peek() != 'a') {
                    return false;
                }
                st.push(ch);
            } 
            else if (ch == 'c') {
                if (st.isEmpty() || st.peek() != 'b') {
                    return false;
                }

                st.pop(); 

                if (st.isEmpty() || st.peek() != 'a') {
                    return false;
                }

                st.pop(); 
            }
        }

        return st.isEmpty();
    }
}