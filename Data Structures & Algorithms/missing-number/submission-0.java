class Solution {
    public int missingNumber(int[] nums) {
        int total = 0;
        for(int i = 0; i < nums.length; i++) {
            total ^= nums[i];
            total ^= i;
        }
        return total ^= nums.length;
    }
}
