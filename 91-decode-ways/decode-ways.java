class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        return check(s, 0,dp);
    }

    public int check(String s, int i, int[] dp) {
        if (i == s.length())
            return 1;
        if (i > s.length())
            return 0;

        if (s.charAt(i) == '0')
            return 0;

        if (dp[i] != 0)
            return dp[i];

        int one = check(s, i + 1, dp);
        int two = 0;
        if (i + 1 < s.length()) {
            int a = (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0';
            if (a > 9 && a < 27) {
                two = check(s, i + 2, dp);
            }
        }
        return dp[i] = one + two;

    }
}