class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                if (check(nums, i)) {
                    if (i - 1 >= 0) {
                        nums[i] = nums[i-1]; 
                    }
                } else {
                    if (i + 1 < nums.length) {
                        nums[i+1] = nums[i];    
                    }
                }
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int[] nums, int i) {
        if (i - 1 < 0) {
            return true;
        }
        if (i + 1 > nums.length - 1) {
            return true;
        }
        return nums[i-1] < nums[i+1];
    }
}
