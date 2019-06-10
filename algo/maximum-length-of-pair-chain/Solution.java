class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length < 2) {
            return pairs.length;
        }
        int max = 1;
        int[] res = new int[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            res[i] = 1;
        }
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return arr1[1] >= arr2[1] ? 1 : -1;       
            }});
        for (int i = 1; i < pairs.length; i++) {
            for (int j = i - 1;  j >= 0; j--) {
                if (pairs[j][1] < pairs[i][0] && res[i] <= res[j]) {
                    res[i] = res[j] + 1;
                    max = max < res[i]? res[i] : max;
                }
            }
        }
        return max;
    }
}
