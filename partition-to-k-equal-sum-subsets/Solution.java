class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        if (nums.length == 1) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] matrix = new boolean[nums.length][target + 1];
        for (int j = 0; j <= target; j++) {
            if (nums[0] == j) {
                matrix[0][j] = true;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i] == j || matrix[i-1][j]) {
                    matrix[i][j] = true;
                    continue;
                }
                if(nums[i] < j) {
                    matrix[i][j] = matrix[i-1][j - nums[i]];
                }
            }
        }
        return matrix[nums.length - 1][target];
    }
}
