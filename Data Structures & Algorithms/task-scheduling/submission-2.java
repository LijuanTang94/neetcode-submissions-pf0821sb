class Solution {
    PriorityQueue<Integer> pq;
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for(char task: tasks) {
            counts[task - 'A']++;
        }
        pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                pq.offer(counts[i]);
            }
        }
        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int k = 0;
            while (k <= n) {
                if (!pq.isEmpty()) {
                    int count = pq.poll();
                    if (count - 1 > 0) {
                        temp.add(count - 1);
                    }
                }
                
                k++;
                time++;
                if (pq.isEmpty() && temp.size() == 0) {
                    break;
                }
            }
            for(int t: temp) {
                pq.offer(t);
            }
        }
        return time;

    }
}
