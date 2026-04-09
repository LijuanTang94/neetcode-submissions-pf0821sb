class Solution {
    public int maxProfit(int[] prices) {
        // 0 hold 1 sell cool
        int n = prices.length;
        if (n == 1) return 0;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[1][0] = -Math.min(prices[0], prices[1]);
        dp[1][1] = Math.max(0, prices[1] - prices[0]);
        dp[1][2] = dp[0][1];
        for(int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}
