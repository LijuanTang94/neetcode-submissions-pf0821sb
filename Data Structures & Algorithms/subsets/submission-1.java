class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        backtrack(nums, 0);
        return res;
        
    }
    private void backtrack(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
