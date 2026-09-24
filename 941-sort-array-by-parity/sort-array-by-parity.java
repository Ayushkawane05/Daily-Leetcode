class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < nums.length && i < j) {
                if (nums[i] % 2 != 0)
                    break;

                i++;
            }

            while (j > 0 && j > i) {
                if (nums[j] % 2 == 0)
                    break;

                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}