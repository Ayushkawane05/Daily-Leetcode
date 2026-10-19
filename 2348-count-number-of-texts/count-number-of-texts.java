class Solution {
    int mod = 1_000_000_007;

    public int countTexts(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return check(s, s.length() - 1, dp);
    }

    public int check(String s, int i, int[] dp) {
        if (i < 0)
            return 1;

        if (dp[i] != -1)
            return dp[i];

        int mov = 0;
        int len = (s.charAt(i) == '7' || s.charAt(i) == '9') ? 4 : 3;

        for (int x = 1; x <= len; x++) {
            if (i - x + 1 < 0 ||
                s.charAt(i) != s.charAt(i - x + 1))
                break;

            mov = (int) ((mov + (long) check(s, i - x, dp)) % mod);
        }

        return dp[i] = mov;
    }
}
