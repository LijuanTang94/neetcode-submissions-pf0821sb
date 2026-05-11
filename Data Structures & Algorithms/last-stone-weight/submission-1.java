class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for(int s: stones) {
            pq.offer(s);
        }
        while (!pq.isEmpty() && pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            if (num1 > num2) {
                pq.offer(num1 - num2);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
