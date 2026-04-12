class Solution {
    Map<String, Integer> map;
    public int maxCoins(int[] nums) {
        map = new HashMap<>();
        int n = nums.length;
        int[] arr = new int[n + 2];
        for(int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        arr[0] = 1;
        arr[n + 1] = 1;
        return dfs(arr, 1, n);
    }
    private int dfs(int[] nums, int l, int r) {
        if (l > r) return 0;
        String temp = l + "," + r;
        if (map.containsKey(temp)) {
            return map.get(temp);
        }
        int res = 0;
        for(int i = l; i <= r; i++) {
            res = Math.max(res, nums[l - 1] * nums[i] * nums[r + 1] + dfs(nums, l, i - 1) + dfs(nums, i + 1, r));
        }
        map.put(temp, res);
        return res;
    }
}
