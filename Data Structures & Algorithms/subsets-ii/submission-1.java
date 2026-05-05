class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }
    private void backtrack(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }

    }
}
