class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1, m = 0;

        while (m <= r) {
            int a = nums[m];
            if (a == 0) {
                int temp = nums[l];
                nums[l++] = nums[m];
                nums[m++] = temp;
                
            } else if (a == 2) {
                int temp = nums[m];
                nums[m] = nums[r];
                nums[r--] = temp;
                
            } else
                m++;
        }
    }
}