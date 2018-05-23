class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] matrix = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = true;
                    count++;
                } else if (j == i + 1 && s.charAt(i) == s.charAt(j)) {
                    matrix[i][j] = true;
                    count++;
                } else if (matrix[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    matrix[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}


