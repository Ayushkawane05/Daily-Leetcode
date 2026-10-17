class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] num : dp) {
            Arrays.fill(num, -1);
        }
        return check(text1, text2, 0, 0,dp);
    }

    public int check(String s, String t, int i, int j, int[][] dp) {

        if (i >= s.length() || j >= t.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i) == t.charAt(j)) {
            return 1 + check(s, t, i + 1, j + 1, dp);
        }

        return dp[i][j] = Math.max(check(s, t, i, j + 1, dp), check(s, t, i + 1, j, dp));
    }
}