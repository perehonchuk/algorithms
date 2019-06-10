class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.len;) {
            if (nums[j] != 0 && i == j) {
                i++;
                j++;
            } else if (nums[j] == 0) {
                if (nums[i] == 0) {
                    i++;
                } else {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;
                    j++;
                }
            }
        }
    }
}
