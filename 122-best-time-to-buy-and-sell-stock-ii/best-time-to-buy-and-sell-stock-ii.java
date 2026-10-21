class Solution {
    public int maxProfit(int[] nums) {
        int[][] dp = new int[nums.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return check(nums, 0, 0, dp);
    }

    public int check(int[] nums, int i, int j, int[][] dp) {
        if (i == nums.length) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];

        if (j == 0) {
            return dp[i][j] = Math.max(-nums[i] + check(nums, i + 1, 1, dp), check(nums, i + 1, 0, dp));
        } else {
            return dp[i][j] = Math.max(nums[i] + check(nums, i + 1, 0, dp), check(nums, i + 1, 1, dp));
        }
    }
}