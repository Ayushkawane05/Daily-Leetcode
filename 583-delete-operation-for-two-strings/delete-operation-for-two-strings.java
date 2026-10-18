class Solution {
    public int minDistance(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n][m];
        for (int[] num : dp) {
            Arrays.fill(num, -1);
        }
        return check(s, t, n - 1, m - 1, dp);
    }

    public int check(String s, String t, int i, int j, int[][] dp) {
        if (i < 0 && j < 0)
            return 0;

        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == t.charAt(j))
            return check(s, t, i - 1, j - 1, dp);

        else {
            return dp[i][j] = Math.min(1 + check(s, t, i - 1, j, dp), 1 + check(s, t, i, j - 1, dp));
        }
    }
}