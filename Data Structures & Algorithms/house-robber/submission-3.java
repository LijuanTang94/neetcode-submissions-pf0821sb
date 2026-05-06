class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int pre = nums[0];
        int cur = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            int nxt = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = nxt;
        }
        return cur;
    }
}
