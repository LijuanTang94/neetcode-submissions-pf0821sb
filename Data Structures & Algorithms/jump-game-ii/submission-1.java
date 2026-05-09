class Solution {
    public int jump(int[] nums) {
        int cur = 0;
        int far = 0;
        int step = 0;
        int n = nums.length;
        for(int i = 0; i < n - 1; i++) {
            far = Math.max(far, i + nums[i]);
            if (cur == i) {
                step++;
                cur = far;
            }
            
        }
        return step;
    }
}
