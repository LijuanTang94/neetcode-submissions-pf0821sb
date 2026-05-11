class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int num: nums) {
            add(k, num);
        }
    }
    private int add(int k, int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.isEmpty() ? -1 : pq.peek();
    }
    
    public int add(int val) {
        return add(k, val);
    }
}
