class Solution {
    public int splitArray(int[] nums, int k) {
        int l = nums[0], r = 0;
        for(int num: nums) {
            l = Math.max(l, num);
            r += num;
        }
        while (l <= r) {
            int m = l + (r - l) / 2;
            long count = getCount(nums, m);
            if (count > k) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
    private long getCount(int[] nums, int sum) {
        long count = 1;
        int cur = 0;
        for(int num: nums) {
            if (cur + num <= sum) {
                cur += num;
                continue;
            }
            cur = num;
            count++;
        }
        return count;
    }
}