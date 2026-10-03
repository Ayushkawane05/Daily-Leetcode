class Solution {
    public int longestValidParentheses(String s) {
        int open = 0, close = 0, ans = 0;

        for (char a : s.toCharArray()) {
            if (a == '(')
                open++;
            else if (a == ')')
                close++;

            if (open == close) {
                ans = Math.max(ans, open + close);
            } else if (close > open) {
                open = 0;
                close = 0;
            }
        }
        open = close = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                open++;
            else
                close++;

            if (close < open) {
                open = close = 0;

            } else if (open == close) {
                ans = Math.max(ans, open + close);
            }
        }
        return ans;
    }
}