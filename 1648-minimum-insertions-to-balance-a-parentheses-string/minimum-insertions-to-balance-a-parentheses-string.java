class Solution {
    public int minInsertions(String s) {
        int open = 0, close = 0, ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                open++;
            else {
                if (open == 0) {
                    if (i+1 < s.length() && s.charAt(i + 1) == ')') {
                        i++;
                    } else {
                        ans++;
                    }
                    ans++;
                }

                else {
                    if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                        i++;
                    } else {
                        ans++;
                        ;

                    }
                    open--;
                }
            }
        }
        return ans + open * 2;
    }
}