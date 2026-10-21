class Solution {
    public int maxProfit(int[] nums) {
        Integer[][][] dp = new Integer[nums.length][2][2];
        return check(nums, 0, 0, 1, dp);
    }

    public static int check(int[] nums, int i, int b, int k, Integer[][][] dp) {
        if (i == nums.length || k < 0)
            return 0;
        if (dp[i][b][k] != null)
            return dp[i][b][k];

        if (b == 0) {

            return dp[i][b][k] = Math.max(-nums[i] + check(nums, i + 1, 1, k, dp), check(nums, i + 1, 0, k, dp));

        } else {
            return dp[i][b][k] = Math.max(nums[i] + check(nums, i + 1, 0, k - 1, dp), check(nums, i + 1, 1, k, dp));
        }
    }

}