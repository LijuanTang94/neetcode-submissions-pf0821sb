class Solution {
    
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] time: times) {
            int ui = time[0], vi = time[1], ti = time[2];
            graph.get(ui).add(new int[] {ti, vi});
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, k});
        int maxDist = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int dist = cur[0];
            int node = cur[1];
            if (visited.contains(node)) continue;
            visited.add(node);
            maxDist = Math.max(maxDist, dist);
            for(int[] neighbor: graph.get(node)) {
                if (visited.contains(neighbor[1])) continue;
                pq.offer(new int[] {dist + neighbor[0], neighbor[1]});
            }

        }
        return visited.size() == n ? maxDist : -1;
    }
}
