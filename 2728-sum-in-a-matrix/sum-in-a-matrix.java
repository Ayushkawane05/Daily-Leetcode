class Solution {
    public int matrixSum(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int ans = 0;

        for (int[] arr : nums) {
            Arrays.sort(arr);
        }

        for (int j = m - 1; j >= 0; j--) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(nums[i][j], max);
            }

            ans += max;
        }

        return ans;
    }
}