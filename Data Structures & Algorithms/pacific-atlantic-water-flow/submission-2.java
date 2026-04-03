class Solution {
    boolean[][] pac, atl;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        pac = new boolean[m][n];
        atl = new boolean[m][n];
        List<List<Integer>> res = new ArrayList<>();
        
        for (int col = 0; col < n; col++) {
            dfs(heights, 0, col, heights[0][col], pac);
            dfs(heights, m - 1, col, heights[m - 1][col], atl);
        }
        for (int row = 0; row < m; row++) {
            dfs(heights, row, 0, heights[row][0], pac);
            dfs(heights, row, n - 1, heights[row][n - 1], atl);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    private void dfs(int[][] heights, int row, int col, int preHeight, boolean[][] visited) {
        int m = heights.length;
        int n = heights[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n) return;
        if (visited[row][col]) return;
        if (heights[row][col] < preHeight) return;
        visited[row][col] = true;
        dfs(heights, row + 1, col, heights[row][col], visited);
        dfs(heights, row - 1, col, heights[row][col], visited);
        dfs(heights, row, col - 1, heights[row][col], visited);
        dfs(heights, row, col + 1, heights[row][col], visited);
    }

}
