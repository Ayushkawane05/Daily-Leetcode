class Solution {
    public String minRemoveToMakeValid(String s) {

        StringBuilder ans = new StringBuilder();
        Stack<Integer> st = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(ans.length());
                ans.append(ch);

            } else if (ch == ')') {
                if (st.isEmpty()) {
                    continue;
                } else {
                    ans.append(ch);
                    st.pop();
                }
            } else
                ans.append(ch);
        }
        while (!st.isEmpty()) {
            int n = st.pop();
            ans.deleteCharAt(n);
        }
        return ans.toString();
    }
}