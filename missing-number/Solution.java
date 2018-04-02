class Solution {
    public int missingNumber(int[] nums) {
        long result = 0;
        long sum = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            sum +=nums[i];
            result += i;
        }
        result += i;
        return (int)(result - sum);
    }
}
