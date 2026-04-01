class Solution {
    char[][] board;
    List<List<String>> res;
    List<String> path;
    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for(char[] b: board) {
            Arrays.fill(b, '.');
        }
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(board, n, 0);
        return res;
    }
    private void dfs(char[][] board, int n, int row) {
        if (row == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int col = 0; col < n; col++) {
            if (isValid(board, n, row, col)) {
                board[row][col] = 'Q';
                path.add(new String(board[row]));
                dfs(board, n, row + 1);
                board[row][col] = '.';
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(char[][] board, int n, int row, int col) {
        for(int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            
                if (board[i][j] == 'Q') return false;
        
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            
                if (board[i][j] == 'Q') return false;
         
        }
        return true;
    }
}
