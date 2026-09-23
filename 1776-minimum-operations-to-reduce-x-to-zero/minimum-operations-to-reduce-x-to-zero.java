class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0, ans = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
        }
        sum = sum - x;
        if(sum<0) return -1;

        int j = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            while (temp > sum && j < n) {
                temp -= nums[j++];
            }
            if (temp == sum) {
                ans = Math.min(n - (i - j + 1), ans);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}