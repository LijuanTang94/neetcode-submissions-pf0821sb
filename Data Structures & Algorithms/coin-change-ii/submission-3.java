class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
         for(int coin: coins) {
            for(int i = coin; i <= amount; i++) {
                if (dp[i - coin] == Integer.MAX_VALUE) continue;
                dp[i] += dp[i - coin];
            }
         }
         return dp[amount];
    }
}
