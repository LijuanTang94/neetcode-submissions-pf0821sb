// class Solution {
//     int[] memo;
//     public int change(int amount, int[] coins) {
//         memo = new int[amount + 1];
//         Arrays.fill(memo, -1);
//     }
//     private int dfs(int target, int[] coins) {
//         if (memo[target] != -1) {
//             return memo[target];
//         }
//         int res = 0;
//         for(int i = 0; i < coins; i++) {

//         }
//     }
// }
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin: coins) {
            for(int i = 1; i <= amount; i++) {
                if (i >= coin && dp[i - coin] != 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}