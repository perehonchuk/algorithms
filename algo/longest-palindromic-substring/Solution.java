class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }
        int n = s.length();
        boolean [][]matrix = new boolean[n][n];
        int maxI = -1;
        int maxJ = -1;
        for (int i = n - 1; i >= 0; i --) {
            for (int j = i; j < n; j++) {
                if (i == j || ((j == i + 1 || matrix[i + 1][j - 1]) && s.charAt(i) == s.charAt(j))) {
                    matrix[i][j] = true;
                    if (j - i >= maxJ - maxI) {
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }
        return s.substring(maxI, maxJ + 1);
    }
}
