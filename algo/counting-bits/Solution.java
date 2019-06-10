class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = -1;
        }
        for (int n = 0; n <= num; n++) {
            int i = n;
            int b = 0;
            while (i > 0) {
                b += i & 1;
                i = i >> 1;
                if (result[i] >= 0) {
                    b += result[i];
                    break;
                }
            }
            result[n] = b;
        }
        return result;
    }
}
