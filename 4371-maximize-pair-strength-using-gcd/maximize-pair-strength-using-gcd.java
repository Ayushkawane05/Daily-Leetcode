
class Solution {
    public long maxPairStrength(int[] nums) {
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                long product = (long) nums[i] * nums[j];
                long gcdValue = gcd(nums[i], nums[j]);

                ans = Math.max(ans, product / (gcdValue * gcdValue));
            }
        }

        return ans;
    }

    public long gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
