class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) {
            return 0;
        }
        for (int i = 2; i < cost.length; i++) {
            if (cost[i-2] < cost[i-1]) {
                cost[i] += cost[i-2];
            } else {
                cost[i] += cost[i-1];
            }
        }
        return cost[cost.length - 1] < cost[cost.length - 2] ? 
            cost[cost.length - 1]: cost[cost.length - 2];
    }
}
