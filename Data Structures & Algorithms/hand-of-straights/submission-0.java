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
                if (map.getOrDefault(i, 0).equals(0)) return false;
                map.put(i, map.get(i) - 1);
                if (map.get(i).equals(0)) {
                    if (pq.peek() != i) return false;
                    pq.poll();
                }
            }
        }
        return true;
    }
}
