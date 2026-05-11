class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1, p = 0;
        while (p <= r) {
            if (nums[p] == 0) {
                swap(nums, p++, l++);
            } else if (nums[p] == 1){
                p++;
            } else {
                swap(nums, p, r--);
            }
        }
    }
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}