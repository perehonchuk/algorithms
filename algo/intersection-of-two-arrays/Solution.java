class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        for (int n: nums1) {
            nums1Set.add(n);
        }
        Set<Integer> result = new HashSet<>();
        for (int n: nums2) {
            if (nums1Set.contains(n)) {
                result.add(n);
            }
        }
        int []r = new int[result.size()];
        int i = 0;
        for (int n: result) {
            r[i] = n;
            i++;
        }
        return r;
    }
}
