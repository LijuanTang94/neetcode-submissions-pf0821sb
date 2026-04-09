class Solution {
    Map<String, Integer> map; 
    public int findTargetSumWays(int[] nums, int target) {
        map = new HashMap<>();
        return backtrack(nums, 0, 0, target);
    }
    private int backtrack(int[] nums, int start, int cur_sum, int target) {
        StringBuilder sb = new StringBuilder();
        sb.append(start).append(",").append(cur_sum);
        if (map.containsKey(sb.toString())) return map.get(sb.toString());
        if (start == nums.length) {
            if (cur_sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int res = 0;
        res += backtrack(nums, start + 1, cur_sum + nums[start], target);
        res += backtrack(nums, start + 1, cur_sum - nums[start], target);
        map.put(sb.toString(), res);
        return res;
    }
    
}
