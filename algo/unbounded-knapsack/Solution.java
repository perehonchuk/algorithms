public class Solution {

    int unboundedKnapsack(int k, int[] arr) {
        if (arr.length == 0 || k == 0) {
            return 0;
        }
        boolean[] res = new boolean[k + 1];
        for (int a: arr) {
            if (a < res.length) {
                res[a] = true;   
            }
        }

        for (int i = 2; i <= k; i++) {
            for (int j = i - 1; j >= 0;) {
                if (!res[j] || !res[i - j]) {
                    j--;
                } else {
                    res[i] = true;
                    break;
                }
            }
        }
        for (int i = k; i >= 0; i--) {
            if (res[i]) {
                return i;            
            }
        }
        return 0;
    }
}