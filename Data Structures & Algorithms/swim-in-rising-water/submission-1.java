class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] {grid[0][0], 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] == m - 1 && cur[2] == n - 1) return cur[0];
            if (visited[cur[1]][cur[2]]) continue;
            visited[cur[1]][cur[2]] = true;
            for(int[] dir : dirs) {
                int nextX = cur[1] + dir[0];
                int nextY = cur[2] + dir[1];
                if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n) continue;
                if (visited[nextX][nextY]) continue;
                int cost = Math.max(cur[0], grid[nextX][nextY]);
                pq.offer(new int[] {cost, nextX, nextY});
            }
        }
        return 0;
    }
}
