class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int res1 = rob(nums, 0, n - 2);
        int res2 = rob(nums, 1, n - 1);
        return Math.max(res1, res2);
    }
    private int rob(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        if (l + 1 == r) return Math.max(nums[l], nums[r]);
        int prev = nums[l];
        int cur = Math.max(nums[l], nums[l + 1]);
        for(int i = l + 2; i <= r; i++) {
            int next = Math.max(prev + nums[i], cur);
            prev = cur;
            cur = next;
        }
        return cur;
    }
}
