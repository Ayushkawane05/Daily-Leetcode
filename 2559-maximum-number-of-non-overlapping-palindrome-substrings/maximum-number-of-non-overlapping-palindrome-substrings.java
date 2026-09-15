class Solution {
    public int maxPalindromes(String s, int k) {
        if (k == 1)
            return s.length();
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return check(s, 0, k, dp);
    }

    public int check(String s, int i, int k, int dp[]) {
        if (i >= s.length())
            return 0;

        if (dp[i] != -1)
            return dp[i];
        int ans = check(s, i + 1, k, dp);

        for (int j = i + k - 1; j < s.length(); j++) {
            if (ispal(s, i, j)) {
                ans = Math.max(ans, 1 + check(s, j + 1, k, dp));
            }
        }
        return dp[i] = ans;
    }

    public boolean ispal(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}