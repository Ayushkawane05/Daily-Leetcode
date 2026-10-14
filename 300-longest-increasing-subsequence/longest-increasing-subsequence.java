class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];

        for (int[] num : dp) {
            Arrays.fill(num, -1);
        }

        return check(nums, 0, -1, dp);
    }

    public int check(int[] nums, int i, int prev, int[][] dp) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }

        int not = check(nums, i + 1, prev, dp);

        int take = 0;

        if (prev == -1 || nums[i] > nums[prev]) {
            take = 1 + check(nums, i + 1, i, dp);
        }

        return dp[i][prev + 1] = Math.max(take, not);
    }
}
