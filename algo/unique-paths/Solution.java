class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] cache = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                cache[i][j] = compute(cache, i, j);
            }
        }
        return cache[0][0];
        
    }

    private int compute(int[][] cache, int i, int j) {
        if (i == cache.length - 1) {
            return 1;
        }
        if (j == cache[0].length - 1) {
            return 1;
        }
        return cache[i+1][j] + cache[i][j+1];
    }
}
