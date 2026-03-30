class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, target, 0);
        return res;
    }
    private void dfs(int[] nums, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < nums.length; i++) {
            if (nums[i] > target) return;
            path.add(nums[i]);
            dfs(nums, target - nums[i], i);
            path.remove(path.size() - 1);
        }
    }
}
