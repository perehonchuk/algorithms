class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int n: nums1) {
            count.compute(n, (k, v) -> v == null? 1 : v + 1);
        }
        for (int n: nums2) {
            Integer c = count.computeIfPresent(n, (k, v) -> v - 1);
            if (c != null && c >= 0) {
                result.add(n);
            }
        }
        int []r = new int[result.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = result.get(i); 
        }
        return r;
    }
}
