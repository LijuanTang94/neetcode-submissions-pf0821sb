class Solution {
    public boolean canJump(int[] nums) {
        int far = 0;
        int n = nums.length;
        for(int i = 0; i < n - 1; i++) {
            if (i > far) return false;
            far = Math.max(far, i + nums[i]);
        }
        return far >= n - 1;
    }
}
