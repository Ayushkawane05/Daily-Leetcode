class Solution {
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if ((m + n - 1) % 2 != 0) return false;
        if (grid[0][0] == ')' || grid[n-1][m-1] == '(') return false;
        Boolean dp[][][] = new Boolean[grid.length][grid[0].length][m + n + 1];
        return check(grid, 0, 0, 0, dp);

    }

   private boolean check(char[][] grid, int i, int j, int balance, Boolean[][][] memo) {
        int m = grid.length, n = grid[0].length;
        balance += grid[i][j] == '(' ? 1 : -1;
        if (balance < 0) return false;
        if (i == m - 1 && j == n - 1) return balance == 0;
        if (memo[i][j][balance] != null) return memo[i][j][balance];
        boolean res = false;
        if (i + 1 < m) res |= check(grid, i + 1, j, balance, memo);
        if (!res && j + 1 < n) res |= check(grid, i, j + 1, balance, memo);
        memo[i][j][balance] = res;
        return res;
    }
}