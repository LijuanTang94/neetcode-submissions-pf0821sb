class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++) {
            if (fast < 1 || nums[fast] != nums[slow - 1]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}