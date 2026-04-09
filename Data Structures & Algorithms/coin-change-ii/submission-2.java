class Solution {
    int[][] memo;
    public int change(int amount, int[] coins) {
        memo = new int[amount + 1][coins.length + 1];
        for(int[] m: memo) Arrays.fill(m, -1);
        return dfs(coins, 0, amount);
    }
    private int dfs(int[] coins, int start, int target) {
        if (start == coins.length || target < 0) return 0;
        if (target == 0) return 1;
        if (memo[target][start] != -1) return memo[target][start];
        int res = 0;
       
        res += dfs(coins, start + 1, target) + dfs(coins, start, target - coins[start]);
        memo[target][start] = res;
        return res;
    }
}
// class Solution {
//     public int change(int amount, int[] coins) {
//         int[] dp = new int[amount + 1];
//         dp[0] = 1;
//         for(int coin: coins) {
//             for(int i = 1; i <= amount; i++) {
//                 if (i >= coin && dp[i - coin] != 0) {
//                     dp[i] += dp[i - coin];
//                 }
//             }
//         }
//         return dp[amount];
//     }
// }