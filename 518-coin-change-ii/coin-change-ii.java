class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount + 1];
        for(int[] num: dp){
            Arrays.fill(num,-1);
        }
        return check(coins.length - 1, amount, coins, dp);
    }

    public int check(int i, int amount, int[] coins, int[][] dp) {
        if (amount == 0)
            return 1;
        if (amount < 0)
            return 0;
        if (i == 0) {
            if (amount % coins[i] == 0)
                return 1;
            else
                return 0;
        }
        if (dp[i][amount] != -1)
            return dp[i][amount];

        int not = check(i - 1, amount, coins, dp);
        int take = 0;
        if (amount >= coins[i]) {
            take = check(i, amount - coins[i], coins, dp);
        }
        return dp[i][amount] = not + take;
    }
}