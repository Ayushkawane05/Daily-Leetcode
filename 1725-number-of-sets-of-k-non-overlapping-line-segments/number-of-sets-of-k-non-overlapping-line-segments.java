class Solution {
    int mod = 1000000007;
    Integer[][][] dp;

    public int numberOfSets(int n, int k) {
        dp = new Integer[n][k + 1][2];
        return helper(0, k, 0, n);
    }

    public int helper(int i, int k, int idx, int n) {
        if (k == 0)
            return 1;
        if (i == n)
            return 0;
        if (dp[i][k][idx] != null)
            return dp[i][k][idx];
        long res = 0;
        if (idx == 0) {
            res = (res + helper(i + 1, k, 0, n)) % mod;
            res = (res + helper(i + 1, k, 1, n)) % mod;
        } else {
            res = (res + helper(i + 1, k, 1, n)) % mod;
            res = (res + helper(i, k - 1, 0, n)) % mod;
        }
        return dp[i][k][idx] = (int) res;
    }
}