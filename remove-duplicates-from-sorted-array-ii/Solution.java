class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 1;
        int z = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                z++;
            } else {
                if (z == 0) {
                    nums[j] = nums[i];
                    j++;
                } else {
                    nums[j] = nums[i-1];
                    nums[j+1] = nums[i];
                    j+=2;
                }
                z = 0;
            }
        }
        if (z > 0) {
            nums[j] = nums[nums.length - 1];
            j++;
        }
        return j;
    }
}
