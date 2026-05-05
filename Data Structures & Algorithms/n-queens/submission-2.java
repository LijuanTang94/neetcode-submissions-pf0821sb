class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] chess = new char[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(chess[i], '.');
        }
        backtrack(chess, n, 0);
        return res;
    }
    private void backtrack(char[][] chess, int n, int row) {
        if (row == n) {
            List<String> path = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                path.add(new String(chess[i]));
            }
            res.add(new ArrayList<>(path));
            return;
        }
        for(int j = 0; j < chess[0].length; j++) {
            if (check(chess, row, j)) {
                chess[row][j] = 'Q';
                backtrack(chess, n, row + 1);
                chess[row][j] = '.';
            }
        }
    }
    private boolean check(char[][] chess, int row, int col) {
        int m = chess.length;
        int n = chess[0].length;
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') return false;
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chess[i][j] == 'Q') return false;
        }
        for(int i = row - 1; i >= 0; i--) {
            if (chess[i][col] == 'Q') return false;
        }
        return true;
    }
}
