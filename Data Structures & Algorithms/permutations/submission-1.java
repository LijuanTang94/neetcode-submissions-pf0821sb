class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        res = new ArrayList<>();
        path = new ArrayList<>();
        backtrack(nums);
        return res;
    }
    private void backtrack(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            path.add(nums[i]);
            visited[i] = true;
            backtrack(nums);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
