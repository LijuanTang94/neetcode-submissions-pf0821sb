class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        for(int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        arr[0] = 1;
        arr[n + 1] = 1;
        //l r 开区间 0 n + 1
        int[][] dp = new int[n + 2][n + 2];
        for(int len = 2; len <= n + 1; len++) {
            for(int l = 0; l + len <= n + 1; l++) {
                int r = len + l;
                for(int k = l + 1; k < r; k++) {
                    dp[l][r] = Math.max(dp[l][r], arr[l] * arr[k] * arr[r] + dp[l][k] + dp[k][r]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
