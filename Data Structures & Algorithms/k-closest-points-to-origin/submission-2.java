class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), a[0] * a[0] + a[1] * a[1]));
        for(int[] point: points) {
            pq.offer(new int[]{point[0], point[1]});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] res = new int[k][2];
        int i = 0;
        while (!pq.isEmpty() && i < k) {
            int[] p = pq.poll();
            res[i][0] = p[0];
            res[i][1] = p[1];
            i++;
        }
        return res;

    }
}
