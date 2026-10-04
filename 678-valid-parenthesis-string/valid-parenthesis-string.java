class Solution {
    public boolean checkValidString(String s) {
        int open = 0, close = 0, star = 0;

        for (char a : s.toCharArray()) {
            if (a == '(')
                open++;
            else if (a == ')')
                close++;
            else
                star++;

            if (close > open && close - open > star)
                return false;
        }

        if (Math.abs(open - close) > star)
            return false;

        open = close = star = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char a = s.charAt(i);
            if (a == '(')
                open++;
            else if (a == ')')
                close++;
            else
                star++;

            if (open > close && star < open - close)
                return false;
        }
        return true;
    }
}