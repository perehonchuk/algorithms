class Solution {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        if (l == 0) {
            return 0;
        }
        int[] lis = new int[l];
        for (int i = 0; i < l; i++) {
            lis[i] = 1;
        }
        
        int max = 1;
        for (int i = l - 2; i >= 0; i--) {
            for (int j = i + 1; j < l; j++) {
                if (nums[j] > nums[i]) {
                    if (lis[i] < lis[j] + 1) {
                        lis[i] = lis[j] + 1;
                        if (max < lis[i]) {
                            max = lis[i];
                        }
                    }
                }
            }
        }
        return max;
    }
}
