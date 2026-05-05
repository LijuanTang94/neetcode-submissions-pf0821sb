class Solution {
    int max = 0;
    boolean[][] visited;
    int count;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                count = 0;
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j);
                    max = Math.max(max, count);
                }
            }
        }
        return max;

    }
    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if (visited[i][j] || grid[i][j] == 0) return;
        count++;
        visited[i][j] = true;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
