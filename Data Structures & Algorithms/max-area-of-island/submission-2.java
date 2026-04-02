class Solution {
    int max = 0;
    int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                   max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }
    private int dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        int cur = 1;
        for(int[] dir: dirs) {
            int nexti = i + dir[0];
            int nextj = j + dir[1];
            if (nexti < 0 || nextj < 0 || nexti >= grid.length || nextj >= grid[0].length) continue;
            if (grid[nexti][nextj] == 1) {
                cur += dfs(grid, nexti, nextj);
            }
        }
        return cur;
    }

}
