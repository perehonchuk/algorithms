class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        Integer maxPrice = null;
        int diff = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                maxPrice = null;
            } else if (maxPrice == null || maxPrice < prices[i]) {
                maxPrice = prices[i];
                if (diff < maxPrice - minPrice) {
                    diff = maxPrice - minPrice;   
                }
            }
        }
        return diff;
    }
}
