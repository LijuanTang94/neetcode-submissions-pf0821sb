class Solution {
    PriorityQueue<int[]> pq;
    public int[][] kClosest(int[][] points, int k) {
        pq = new PriorityQueue<>((a, b) -> Integer.compare(f(b), f(a)));
        for(int[] point: points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.toArray(new int[0][]);
    }
    private int f(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
}
