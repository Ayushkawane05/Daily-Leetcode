class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int a = nums[i];
            while (a > 0) {
                sum += a % 10;
                a = a / 10;
            }
            if(sum == i) return i;
        }
        return -1;
    }
}