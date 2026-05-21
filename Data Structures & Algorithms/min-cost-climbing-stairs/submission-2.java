class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int pre = 0;
        int cur = 0;
        for(int i = 2; i <= n; i++) {
            int nxt = Math.min(pre + cost[i - 2], cur + cost[i - 1]);
            pre = cur;
            cur = nxt;
        }
        return cur;
    }
}
