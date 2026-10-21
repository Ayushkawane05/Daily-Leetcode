class Solution {
    public int maxProfit(int[] nums) {
        int profit = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                profit += -nums[i] + nums[i + 1];
            }
        }
        return profit;

    }
}