class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key: map.keySet()) {
            int freq = map.get(key);
            pq.offer(new int[] {freq, key});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        int idx = 0;
        while (!pq.isEmpty()) {
            res[idx++] = pq.poll()[1];
        }
        return res;
    }
}
