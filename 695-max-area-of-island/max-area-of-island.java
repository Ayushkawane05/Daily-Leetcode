class Solution {
    int[][] arr = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int maxAreaOfIsland(int[][] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 1)
                    ans = Math.max(check(nums, i, j), ans);
            }
        }
        return ans;
    }

    public int check(int[][] nums, int i, int j) {

        if (nums[i][j] == 0) {
            return 0;

        }
        nums[i][j] = 0;
        int ans = 1;
        for (int x = 0; x < 4; x++) {
            int a = i + arr[x][0];
            int b = j + arr[x][1];

            if (a < 0 || b < 0 || a >= nums.length || b >= nums[0].length || nums[a][b] == 0)
                continue;

            ans = ans + check(nums, a, b);

        }
        return ans;

    }
}