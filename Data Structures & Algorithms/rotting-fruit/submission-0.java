class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        int minutes = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean isRotten = false;
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for(int[] dir: dirs) {
                    int nexti = cur[0] + dir[0];
                    int nextj = cur[1] + dir[1];
                    if (nexti < 0 || nextj < 0 || nexti >= m || nextj >= n) continue;
                    if (grid[nexti][nextj] == 1) {
                        q.offer(new int[] {nexti, nextj});
                        grid[nexti][nextj] = 2;
                        isRotten = true;
                        fresh--;
                    }
                }
            }
            if (isRotten) {
                minutes++;
            }
        }
        return fresh == 0 ? minutes : -1;
    }
}
