class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int ans = 0;

        for (int num : nums) {
            String temp = String.valueOf(num);
            for (char ch : temp.toCharArray()) {

                if (ch - '0' == digit) {
                    ans++;
                }
            }
        }

        return ans;
    }
}