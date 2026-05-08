class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        int goal = (sum + target) / 2;
        if (goal < 0) return 0;
        int[] dp = new int[goal + 1];
        dp[0] = 1;
        for(int num: nums) {
            for(int j = goal; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[goal];
    }
}
