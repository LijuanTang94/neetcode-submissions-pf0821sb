class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Map<Integer, Integer> freqs = new HashMap<>();
        for(int num: nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }
        for(int key: freqs.keySet()) {
            pq.offer(new int[] {key, freqs.get(key)});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        int idx = 0;
        while (!pq.isEmpty() && idx < k) {
            res[idx++] = pq.poll()[0];
        }
        return res;
    }
}
