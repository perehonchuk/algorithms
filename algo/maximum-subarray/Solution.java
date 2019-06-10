class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int e = nums[i];
            if (nums[i-1] + e > e) {
                nums[i] += nums[i-1];
            }
            e = e > nums[i]? e : nums[i];
            if (e > max) {
                max = e;
            }
        }
        return max;
    }
}
