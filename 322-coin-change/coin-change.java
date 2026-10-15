class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = (int) 1e9;

        int[][] dp = new int[n][amount + 1];

        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) {
                dp[0][t] = t / coins[0];
            } else {
                dp[0][t] = INF;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= amount; t++) {

                int not = dp[i - 1][t];

                int take = INF;

                if (coins[i] <= t) {
                    take = 1 + dp[i][t - coins[i]];
                }

                dp[i][t] = Math.min(not, take);
            }
        }

        int ans = dp[n - 1][amount];

        return ans >= INF ? -1 : ans;
    }
}
