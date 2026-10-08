class Solution {
    public int orangesRotting(int[][] nums) {
        int count = 0;
        int[] rot = new int[2];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 1)
                    count++;
                else if (nums[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }
            }
        }
        int min = 0;
        int[][] arr = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (count > 0) {
            int n = q.size();
            if (q.isEmpty()) {
                return -1;
            }

            for (int i = 0; i < n; i++) {
                int[] temp = q.remove();
                int a = temp[0];
                int b = temp[1];

                for (int j = 0; j < arr.length; j++) {
                    int x = a + arr[j][0];
                    int y = b + arr[j][1];

                    if (x < 0 || y < 0 || x == nums.length || y == nums[0].length)
                        continue;

                    if (nums[x][y] == 0)
                        continue;

                    else {
                        if (nums[x][y] == 1) {
                            count--;
                            nums[x][y] = 2;

                            q.offer(new int[] { x, y });
                        }
                    }
                }

            }
            min++;
        }
        if (count == 0)
            return min;
        else
            return -1;
    }
}