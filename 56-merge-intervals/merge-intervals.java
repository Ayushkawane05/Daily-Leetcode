class Solution {
    public int[][] merge(int[][] nums) {

        if (nums.length <= 1) {
            return nums;
        }

        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> lis = new ArrayList<>();

        int first = nums[0][0];
        int sec = nums[0][1];

        for (int k = 1; k < nums.length; k++) {

            if (sec >= nums[k][0]) {
                sec = Math.max(sec, nums[k][1]);
            } 
            else {
                lis.add(new int[]{first, sec});

                first = nums[k][0];
                sec = nums[k][1];
            }
        }

        lis.add(new int[]{first, sec});

        return lis.toArray(new int[lis.size()][]);
    }
}