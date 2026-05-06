class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int pre = 1;
        int cur = 2;
        for(int i = 3; i <= n; i++) {
            int nxt = pre + cur;
            pre = cur;
            cur = nxt;
        }
        return cur;
    }
}
