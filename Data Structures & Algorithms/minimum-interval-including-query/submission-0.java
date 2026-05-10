class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int n = queries.length;
        Integer[] idx = new Integer[n];
        for(int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> Integer.compare(queries[a], queries[b]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        int[] res = new int[n];
        for(int j: idx) {
            int q = queries[j];
            while (i < intervals.length && intervals[i][0] <= q) {
                int len = intervals[i][1] - intervals[i][0] + 1;
                pq.offer(new int[] {len, intervals[i][1]});
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < q) {
                pq.poll();
            }
            res[j] = pq.isEmpty() ? -1 : pq.peek()[0];
        }
        return res;

    }
}
