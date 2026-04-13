class Solution {
    PriorityQueue<int[]> pq;
    List<int[]> res;
    public int[][] kClosest(int[][] points, int k) {
        res = new ArrayList<>();
        pq = new PriorityQueue<>((a, b) -> Integer.compare(f(b), f(a)));
        for(int[] point: points) {
            pq.offer(point);
            while (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        return res.toArray(new int[0][]);
    }
    private int f(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
}
