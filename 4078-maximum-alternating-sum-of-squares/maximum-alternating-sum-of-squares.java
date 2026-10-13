class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squared = new long[n];

        for (int i = 0; i < n; i++) {
            squared[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squared);

        long ans = 0;

        for (int i = 0; i < n / 2; i++) {
            ans += squared[n - 1 - i] - squared[i];
        }

        if (n % 2 != 0) {
            ans += squared[n / 2];
        }

        return ans;
    }
}