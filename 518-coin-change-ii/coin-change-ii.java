class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = 1;
            else
                dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int not = dp[i - 1][j];
                int take = 0;
                if (j >= coins[i]) {
                    take = dp[i][j - coins[i]];
                }
                dp[i][j] = not + take;
            }
        }
        return dp[dp.length - 1][amount];

    }

}