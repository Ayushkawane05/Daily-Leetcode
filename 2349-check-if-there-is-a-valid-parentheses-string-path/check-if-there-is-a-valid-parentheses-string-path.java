class Solution {
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Boolean dp[][][] = new Boolean[grid.length][grid[0].length][m + n + 1];
        return check(grid, 0, 0, 0, dp);

    }

    public boolean check(char[][] grid, int i, int j, int open, Boolean[][][] dp) {

        if (i == grid.length || j == grid[0].length) {
            return false;
        }

        if (grid[i][j] == '(')
            open++;
        else if (grid[i][j] == ')')
            open--;

        if (open < 0)
            return false;

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            if (open == 0)
                return true;
            else
                return false;
        }

        if (dp[i][j][open] != null) {
            return dp[i][j][open];
        }

        boolean down = check(grid, i + 1, j, open, dp);
        boolean up = check(grid, i, j + 1, open, dp);

        return dp[i][j][open] = down || up;
    }
}