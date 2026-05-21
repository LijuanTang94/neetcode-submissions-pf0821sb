class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(f(nums, 0, n - 2), f(nums, 1, n - 1));
    }
    private int f(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        if (l + 1 == r) return Math.max(nums[l], nums[l + 1]);
        int pre = nums[l];
        int cur = Math.max(nums[l], nums[l + 1]);
        for(int i = l + 2; i <= r; i++) {
            int nxt = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = nxt;
        }
        return cur;
    }
}
