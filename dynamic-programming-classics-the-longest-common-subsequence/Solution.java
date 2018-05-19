public class Solution {

    //https://www.youtube.com/watch?v=NnD96abizww
    public int[] longestCommonSubsequence(int[] a, int[] b) {
        if (a.length == 0) {
            return a;
        }
        if (b.length == 0) {
            return b;
        }
        int [][] matrix = new int[a.length + 1][b.length + 1];
        int max = 0;
        int maxI = 0;
        int maxJ = 0;
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i-1] == b[j-1]) {
                    matrix[i][j] = 1 + matrix[i-1][j-1];
                    if (max < matrix[i][j]) {
                        max = matrix[i][j];
                        maxI = i;
                        maxJ = j;
                    }
                } else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }
        int []res = new int[max];
        while(max > 0) {
            int curr = matrix[maxI][maxJ];
            if (curr == matrix[maxI - 1][maxJ]) {
                maxI = maxI - 1;
            } else if (curr == matrix[maxI][maxJ - 1]) {
                maxJ = maxJ - 1;
            } else {
                res[max - 1] = a[maxI - 1];
                max--;
                maxI--;
                maxJ--;                
            }
        }
        return res;
    }
}