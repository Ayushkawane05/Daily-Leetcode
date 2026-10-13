class Solution {
    public int eraseOverlapIntervals(int[][] nums) {
        Arrays.sort(nums, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int n = nums.length;
        int last = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i][0] >= last) {

                count++;
                last = nums[i][1];
            }
        }
        return n - count;
    }
}