class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int[] arr = new int[nums.length];

        arr[0] = nums[0];
        arr[1] = nums[1];

        int j = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == arr[j - 1] && nums[i] == arr[j - 2]) {
                continue;
            }

            arr[j++] = nums[i];
        }

        for (int i = 0; i < j; i++) {
            nums[i] = arr[i];
        }

        return j;
    }
}