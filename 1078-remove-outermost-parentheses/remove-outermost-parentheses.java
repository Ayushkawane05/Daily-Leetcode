class Solution {
    public String removeOuterParentheses(String s) {
        int c = 0;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                if (c > 0)
                    ans.append(ch);
                c++;

            } else {
                c--;
                if (c > 0)
                    ans.append(ch);
            }

        }
        return ans.toString();

    }
}