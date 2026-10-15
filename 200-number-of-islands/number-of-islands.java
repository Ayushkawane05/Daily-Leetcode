class Solution {
    public int numIslands(char[][] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int m = nums[0].length;
        int ans = 0;

        int[][] directions = {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (nums[i][j] == '1') {
                    ans++;
                    check(nums, i, j);

                }
            }
        }

        return ans;
    }

    public void check(char[][] nums, int i, int j) {
        int n = nums.length;
        int m = nums[0].length;
        if (i >= n || i < 0 || j >= m || j < 0 || nums[i][j] != '1')
            return;
        nums[i][j] = '2';
        int[][] arr = {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };
        for (int x = 0; x < 4; x++) {
            check(nums, i + arr[x][0], j + arr[x][1]);
        }
        return;
    }

}
