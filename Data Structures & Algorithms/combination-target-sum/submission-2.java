class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, target, 0);
        return res;
    }
    private void backtrack(int[] nums, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for(int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrack(nums, target - nums[i], i);
            path.remove(path.size() - 1);
        } 
    }
}
