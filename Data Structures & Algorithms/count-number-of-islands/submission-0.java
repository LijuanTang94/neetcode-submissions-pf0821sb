class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
        
    }
    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for(int[] dir: dirs) {
            int nexti = i + dir[0];
            int nextj = j + dir[1];
            if (nexti < 0 || nextj < 0 || nexti >= grid.length || nextj >= grid[0].length) continue;
            if (grid[nexti][nextj] == '1') {
                dfs(grid, nexti, nextj);
            }
        }
    }
}
