class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                grid[cur[0]][cur[1]] = dist;
                for(int[] dir: dirs) {
                    int nexti = cur[0] + dir[0];
                int nextj = cur[1] + dir[1];
                if (nexti < 0 || nextj < 0 || nexti >= m || nextj >= n) continue;
                if (grid[nexti][nextj] == Integer.MAX_VALUE) {
                    q.offer(new int[] {nexti, nextj});
                    grid[nexti][nextj] = dist;
                }

                }
                
            }
            dist++;
        }
    }
}
