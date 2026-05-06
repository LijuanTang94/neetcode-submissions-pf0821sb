class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        int n = numCourses;
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int[] pre: prerequisites) {
            indegree[pre[0]]++;
            graph.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            res.add(cur);
            for(int nxt: graph.get(cur)) {
                indegree[nxt]--;
                if (indegree[nxt] == 0) {
                    q.offer(nxt);
                }
            }
        }
        
        if (res.size() != n) {
            return new int[]{};
        }
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
