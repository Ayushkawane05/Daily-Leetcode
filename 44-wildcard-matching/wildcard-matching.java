class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n][m];
        return check(s, p, n - 1, m - 1, dp);
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