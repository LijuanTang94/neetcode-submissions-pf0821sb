class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] time: times) {
            int s = time[0], t = time[1], ti = time[2];
            graph.get(s).add(new int[]{ti, t});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, k});
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[k] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int dis = cur[0];
            int node = cur[1];
            if (dis > res[node]) continue;
            for(int[] edge: graph.get(node)) {
                int weight = edge[0];
                int nxt = edge[1];
                if (weight + dis < res[nxt]) {
                    res[nxt] = weight + dis;
                    pq.offer(new int[] {res[nxt], nxt});
                }
            }
        }
        int ans = 0;
        for(int i = 1; i < res.length; i++) {
            ans = Math.max(ans, res[i]);
            if (res[i] == Integer.MAX_VALUE) {
                return -1;
            }
        }
        return ans;
    }
}
