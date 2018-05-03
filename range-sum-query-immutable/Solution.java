class NumArray {
    private final int[] cache;
    private final int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.cache = new int[nums.length];
        if (nums.length > 0) {
            cache[0] = nums[0];    
        }
        for (int i = 1; i < nums.length; i++) {
            cache[i] = cache[i-1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return cache[j] - cache[i] + nums[i];
    }
}

