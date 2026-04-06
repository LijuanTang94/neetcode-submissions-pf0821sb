class Solution {
    List<List<int[]>> graph;
    Set<Integer> visited;
    public int networkDelayTime(int[][] times, int n, int k) {
        graph = new ArrayList<>();
        visited = new HashSet<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] time: times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[] {k, 0});
        int minDist = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited.contains(cur[0])) continue;
            minDist = Math.max(minDist, cur[1]);
            visited.add(cur[0]);
            for(int[] neighbor: graph.get(cur[0])) {
                if (!visited.contains(neighbor[0])) {
                    pq.offer(new int[]{neighbor[0], neighbor[1] + cur[1]});
                }
                
            }
        }
        return visited.size() == n ? minDist : -1;
    
    }
}
