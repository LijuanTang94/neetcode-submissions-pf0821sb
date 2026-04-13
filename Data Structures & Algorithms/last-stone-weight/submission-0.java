class Solution {
    PriorityQueue<Integer> pq;
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int stone: stones) {
            pq.offer(stone);
        }
        while (!pq.isEmpty() && pq.size() >= 2) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            int diff = num1 - num2;
            if (diff > 0) {
                pq.offer(diff);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
