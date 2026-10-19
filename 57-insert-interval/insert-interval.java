class Solution {
    public int[][] insert(int[][] nums, int[] arr) {

        List<int[]> li = new ArrayList<>();

        int i = 0;
        while (i < nums.length && nums[i][1] < arr[0]) {
            li.add(nums[i]);
            i++;
        }
        int[] temp;
        while (i < nums.length && nums[i][0] <= arr[1]) {
            arr[0] = Math.min(arr[0], nums[i][0]);
            arr[1] = Math.max(arr[1], nums[i][1]);
            i++;
        }
        li.add(arr);
        while (i < nums.length) {
            li.add(nums[i]);
            i++;
        }

        int[][] ans = new int[li.size()][2];

        for (int j = 0; j < li.size(); j++) {
            ans[j] = li.get(j);
        }

        return ans;

    }
}