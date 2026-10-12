class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bit = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    bit[i]++;
                }
            }
        }

        long ans = 0;
        while (k > 0) {

            int num = 0;
            for (int i = 0; i < 32; i++) {
                if (bit[i] != 0) {
                    num = num | (1 << i);
                    bit[i]--;
                }
            }
            ans = (ans + (long) num * num) % 1_000_000_007L;
            k--;
        }
        return (int) ans;
    }
}