class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];

                else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }

                else
                    dp[i][j] = false;
            }
        }
        return dp[n][m];
    }

    public boolean check(String s, String p, int i, int j, Boolean[][] dp) {
        if (j < 0 && i < 0) {
            return true;
        }
        if (j < 0) {
            return false;
        }
        if (i < 0) {
            boolean ans = true;
            while (j >= 0) {
                if (p.charAt(j--) != '*')
                    ans = false;
            }
            return ans;
        }

        if (dp[i][j] != null)
            return dp[i][j];

        if (s.charAt(i) == p.charAt(j))
            return dp[i][j] = check(s, p, i - 1, j - 1, dp);

        else if (p.charAt(j) == '*') {
            return dp[i][j] = check(s, p, i - 1, j - 1, dp) || check(s, p, i - 1, j, dp) || check(s, p, i, j - 1, dp);
        }

        else if (p.charAt(j) == '?')
            return dp[i][j] = check(s, p, i - 1, j - 1, dp);
        else
            return dp[i][j] = false;
    }
}