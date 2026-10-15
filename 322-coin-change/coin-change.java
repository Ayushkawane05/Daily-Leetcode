class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] num : dp) {
            Arrays.fill(num, -1);
        }
        int ans = check(coins, amount, coins.length - 1, dp);
        if (ans >= 1e9)
            return -1;
        return ans;
    }

    public int check(int[] nums, int t, int i, int[][] dp) {
        if (t < 0)
            return (int) 1e9;
        if (i == 0) {
            if (t % nums[i] == 0)
                return t / nums[i];
            else
                return (int) 1e9;
        }
        if (dp[i][t] != -1)
            return dp[i][t];

        int not = check(nums, t, i - 1, dp);
        int take = (int) 1e9;
        if (t >= nums[i]) {
            take = 1 + check(nums, t - nums[i], i, dp);
        }
        return dp[i][t] = Math.min(not, take);
    }
}