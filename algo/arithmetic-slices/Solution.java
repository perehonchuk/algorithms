class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        ArrayList<Integer> cache = new ArrayList<>(1);
        cache.add(1);
        int res = 0;
        int len = 0;
        for (int i = 0; i < A.length - 2; i++) {
            if ((A[i+1] - A[i]) == (A[i+2] - A[i+1])) {
                len++;
                updateCache(len, cache);
            } else {
                if (len > 0) {
                    res += cache.get(len - 1);
                    len = 0;
                }
            }
        }
        if (len > 0) {
            res += cache.get(len - 1);
        }
        return res;
        
    }

    private void updateCache(int len, ArrayList<Integer> cache) {
        if (len > 1 && cache.size() <= len - 1) {
            cache.add(cache.get(cache.size() -1) + len);
        }
    }
}
