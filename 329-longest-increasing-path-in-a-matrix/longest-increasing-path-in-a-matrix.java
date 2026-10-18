class Solution {
    int[][] arr = new int[][] { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };

    public int longestIncreasingPath(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return 0;
        }
        int n = nums.length;
        int m = nums[0].length;
        int max = 0;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, check(nums, i, j, dp));
            }
        }
        return max;
    }

    public int check(int[][] nums, int i, int j, int[][] dp) {
        if (dp[i][j] != 0)
            return dp[i][j];
        int max = 1;
        for (int x = 0; x < 4; x++) {
            int a = arr[x][0] + i;
            int b = arr[x][1] + j;

            if (a < 0 || b < 0 || a >= nums.length || b >= nums[0].length)
                continue;
            if (nums[a][b] <= nums[i][j])
                continue;

            max = Math.max(max, 1 + check(nums, a, b, dp));
        }
        return dp[i][j] = max;
    }
}