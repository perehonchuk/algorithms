class Solution {
    public int rob(int[] nums) {
        return rob(nums, 0, new HashMap<Integer, Integer>());
    }

    public int rob(int[] nums, int r, Map<Integer, Integer> cache) {
        int currRes = 0;
        int nextRes = 0;
        if (cache.containsKey(r)) {
            currRes = cache.get(r);
        } else if (r < nums.length) {
            currRes = nums[r] + rob(nums, r + 2, cache);
            cache.put(r, currRes);
        }
        if (cache.containsKey(r + 1)) {
            nextRes = cache.get(r + 1);
        } else if (r + 1 < nums.length) {
           nextRes = nums[r + 1] + rob(nums, r + 3, cache); 
           cache.put(r + 1, nextRes);
        }
        return currRes > nextRes ? currRes : nextRes;
    }
}
