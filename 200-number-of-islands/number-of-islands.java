class Solution {
    public int numIslands(char[][] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int m = nums[0].length;
        int ans = 0;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (nums[i][j] == '1') {
                    ans++;

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});

                    nums[i][j] = '0';

                    while (!q.isEmpty()) {
                        int[] cell = q.poll();

                        int a = cell[0];
                        int b = cell[1];

                        for (int[] dir : directions) {
                            int c = a + dir[0];
                            int d = b + dir[1];

                            if (c < 0 || c >= n ||
                                d < 0 || d >= m) {
                                continue;
                            }

                            if (nums[c][d] == '0') {
                                continue;
                            }

                            nums[c][d] = '0';
                            q.offer(new int[]{c, d});
                        }
                    }
                }
            }
        }

        return ans;
    }
}
