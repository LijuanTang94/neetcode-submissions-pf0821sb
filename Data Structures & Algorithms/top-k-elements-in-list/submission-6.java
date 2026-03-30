class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for(int key: map.keySet()) {
            pq.offer(new int[] {key, map.get(key)});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        int idx = k - 1;
        while (!pq.isEmpty()) {
            res[idx--] = pq.poll()[0];
            if (idx == -1) break;
        }
        return res;


    }
}
