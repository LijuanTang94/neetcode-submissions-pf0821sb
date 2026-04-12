class Solution {
    Map<String, Integer> map;
    public int longestIncreasingPath(int[][] matrix) {
        map = new HashMap<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(matrix, i, j, -1);
            }
        }
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res = Math.max(res, map.get(i + "," + j));
            }
        }
        return res;
    }
    private int dfs(int[][] matrix, int row, int col, int prev) {
        if (row < 0 || col < 0 || row == matrix.length || col == matrix[0].length || matrix[row][col] <= prev) return 0;
        if (map.containsKey(row + "," + col)) return map.get(row + "," + col);
        int res = 1;
        res = Math.max(res, 1 + dfs(matrix, row + 1, col, matrix[row][col]));
        res = Math.max(res, 1 + dfs(matrix, row - 1, col, matrix[row][col]));
        res = Math.max(res, 1 + dfs(matrix, row, col + 1, matrix[row][col]));
        res = Math.max(res, 1 + dfs(matrix, row, col - 1, matrix[row][col]));
        map.put(row + "," + col, res);
        return res;
    }
}
