class Solution {
    public int minCostConnectPoints(int[][] points) {
        int total = 0;
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[] visited = new boolean[n];
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int idx = cur[1];
            if (visited[idx]) continue;
            total += cur[0];
            visited[cur[1]] = true;
            for(int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int dist = Math.abs(points[idx][0] - points[j][0]) +
                        Math.abs(points[idx][1] - points[j][1]);
                    pq.offer(new int[]{dist, j});
                }
            }
        }
        return total;

    }
}
