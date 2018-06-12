class Solution {
    public int findLength(int[] A, int[] B) {
        int [][] m = new int [B.length + 1][A.length + 1];
        int max = 0;
        for (int i = 1; i <= B.length; i++) {
            for (int j = 1; j <= A.length; j++) {
                if (A[j - 1] == B[i - 1]) {
                    m[i][j] = m[i-1][j-1] + 1;
                    max = max > m[i][j] ? max: m[i][j];
                }
            }
        }
        return max;
    }
}