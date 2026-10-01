class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char top = s.charAt(i);
            if (top == '(' || top == '{' || top == '[') {
                st.push(top);
            } else {
                if (st.isEmpty())
                    return false;
                char p = st.peek();
                if (top == ')' && p == '(')
                    st.pop();
                else if (top == '}' && p == '{')
                    st.pop();
                else if (top == ']' && p == '[')
                    st.pop();
                else return false;
                }
        }
        return st.isEmpty();
    }
}