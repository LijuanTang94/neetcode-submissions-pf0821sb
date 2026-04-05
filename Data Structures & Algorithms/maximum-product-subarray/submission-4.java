class Solution {
    int res = Integer.MIN_VALUE;
    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        for(int num: nums) {
            if (num < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(min * num, num);
            max = Math.max(max * num, num);
            res = Math.max(res, max);
        }
        return res;
    }
}
