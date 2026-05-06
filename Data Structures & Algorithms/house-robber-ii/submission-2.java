class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }
    private int rob(int[] nums, int l, int r) {
        int n = r - l + 1;
        if (n == 1) {
            return nums[l];
        }
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
