class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        if (fresh == 0) return 0;
        int minutes = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean isRotten = false;
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for(int[] dir: dirs) {
                    int nx = cur[0] + dir[0];
                    int ny = cur[1] + dir[1];
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                        continue;
                    }
                    if (grid[nx][ny] == 2) continue;
                    if (grid[nx][ny] == 1) {
                        fresh--;
                        grid[nx][ny] = 2;
                        isRotten = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            if (isRotten) minutes++;
        }
        return fresh == 0 ? minutes : -1;
        
    }
}
