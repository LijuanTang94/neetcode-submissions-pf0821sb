class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int i, int j, int start) {
        if (start == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (visited[i][j]) return false;
        if (board[i][j] != word.charAt(start)) return false;
        visited[i][j] = true;
        boolean found = backtrack(board, word, i + 1, j, start + 1) || backtrack(board, word, i, j + 1, start + 1)
        || backtrack(board, word, i - 1, j, start + 1) || backtrack(board, word, i, j - 1, start + 1);
        visited[i][j] = false;
        return found;
    }
}
