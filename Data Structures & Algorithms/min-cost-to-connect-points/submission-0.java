class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        boolean[] visited = new boolean[n];
        pq.offer(new int[]{0, 0});
        int total = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int i = cur[1];
            if (visited[i]) continue;
            visited[i] = true;
            count++;
            total += cost;
            if (count == n) return total;
            for(int j = 0; j < n; j++) {
                if (visited[j]) continue;
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.offer(new int[]{dist, j});
            }
        }
        return total;
    }
    
}
