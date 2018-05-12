class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0 ;
        }
        int[][] cache = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                cache[i][j] = calc(grid, cache, i, j);
            }
        }
        return cache[0][0];
    }

    private int calc(int [][]grid, int [][]cache, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (i == grid.length - 1) {
            return grid[i][j] + cache[i][j + 1];
        }
        if (j == grid[0].length - 1) {
            return grid[i][j] + cache[i + 1][j];
        }
        return cache[i][j + 1] < cache[i + 1][j]? grid[i][j] + cache[i][j + 1] : grid[i][j] + cache[i + 1][j];
    }
}
