class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char t: tasks) {
            count[t - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for(int c: count){
            if (c > 0) {
                pq.offer(c);
            }
        }
        int res = 0;
        while (!pq.isEmpty()) {
            int k = 0;
            List<Integer> list = new ArrayList<>();
            while (k <= n) {
                if (!pq.isEmpty()) {
                    int cur = pq.poll() - 1;
                    if (cur > 0) {
                        list.add(cur);
                    }
                }
                k++;
                res++;
                if (pq.isEmpty() && list.isEmpty()) break;
            }
            for(int l: list) {
                pq.offer(l);
            }
        }
        return res;
    }
}
