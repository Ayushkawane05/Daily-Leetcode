class Solution {

    public int nearestExit(char[][] nums, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();
        int n = nums.length;
        int m = nums[0].length;
        q.offer(entrance);
        int step = 0;
        int arr[][] = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        nums[entrance[0]][entrance[1]] = '+';

        while (!q.isEmpty()) {
            int len = q.size();
            step++;
            for (int i = 0; i < len; i++) {

                int[] curr = q.poll();
                
                int x = curr[0];
                int y = curr[1];

                for (int j = 0; j < arr.length; j++) {
                    int a = x + arr[j][0];
                    int b = y + arr[j][1];

                    if (a < 0 || b < 0 || a >= n || b >= m)
                        continue;
                    if (nums[a][b] == '+')
                        continue;
                    nums[a][b] = '+';

                    if (a == 0 || b == 0 || a == n - 1 || b == m - 1)
                        return step;

                    q.offer(new int[] { a, b });
                }

            }

        }
        return -1;

    }

}