class Solution {
    int mod = 1_000_000_007;

    public int countTexts(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {

            int mov = 0;
            int len = (s.charAt(i - 1) == '7' || s.charAt(i - 1) == '9') ? 4 : 3;

            for (int x = 1; x <= len; x++) {
                if (i - x < 0 || s.charAt(i - 1) != s.charAt(i - x))
                    break;

                mov = (int) ((mov + (long) dp[i - x])) % mod;
            }

            dp[i] = mov;

        }

        return dp[s.length()];
    }

}
