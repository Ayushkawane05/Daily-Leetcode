class Solution {
    public int sortPermutation(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int num = -1;

        for (int i = 0; i < nums.length; i++) {
            if (arr[i] != nums[i]) {
                num = num & nums[i];
                if (num == 0)
                    return 0;
            }
        }
        return Math.max(num, 0);

    }
}