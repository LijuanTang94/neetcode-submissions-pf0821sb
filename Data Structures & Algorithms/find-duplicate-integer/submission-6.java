class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] res = new int[n + 1];
        for(int num: nums) {
            if (res[num] == num) {
                return num;
            }
            res[num] = num;
        }
        return 0;
    }
}
