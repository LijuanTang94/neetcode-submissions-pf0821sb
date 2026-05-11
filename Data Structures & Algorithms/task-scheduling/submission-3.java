class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        Map<Character, Integer> map = new HashMap<>();
        for(char t: tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        for(int c: map.values()) {
            pq.offer(c);
        }
        while (!pq.isEmpty()) {
            int k = 0;
            List<Integer> list = new ArrayList<>();
            while (k <= n) {
                if (!pq.isEmpty()) {
                    int cur = pq.poll();
                    cur--;
                    if (cur > 0) {
                        list.add(cur);
                    }
                }
                k++;
                count++;
                if (pq.isEmpty() && list.isEmpty()) break;
            }
            for(int i = 0; i < list.size(); i++) {
                pq.offer(list.get(i));
            }
        }
        return count;
    }
}
