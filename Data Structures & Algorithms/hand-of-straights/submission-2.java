class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int h: hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer key: map.keySet()) {
            pq.offer(key);
        }
        while (!pq.isEmpty()) {
            int start = pq.peek();
            for(int i = start; i < start + groupSize; i++) {
                map.put(i, map.getOrDefault(i, 0) - 1);
                if (map.get(i) < 0) return false;
                if (map.get(i) == 0) {
                    if (i != pq.peek()) {
                        return false;
                    }
                    pq.poll();
                }
            }
        }
        return true;
    }
}
