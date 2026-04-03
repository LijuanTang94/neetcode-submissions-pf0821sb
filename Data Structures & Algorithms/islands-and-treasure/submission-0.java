class Solution {
    boolean[][] visited;
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    visited[i][j] = true;
                    q.offer(new int[] {i, j});
                }
            }
        }
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int a = cur[0];
                int b = cur[1];
                grid[a][b] = dist;
                addRoom(grid, a + 1, b, q);
                addRoom(grid, a - 1, b, q);
                addRoom(grid, a, b + 1, q);
                addRoom(grid, a, b - 1, q);
            }
            dist++;
        }

    }
    private void addRoom(int[][] grid, int i, int j, Queue<int[]> q) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1 || visited[i][j]) {
            return;
        }
        q.offer(new int[]{i, j});
        visited[i][j] = true;
    }
}
