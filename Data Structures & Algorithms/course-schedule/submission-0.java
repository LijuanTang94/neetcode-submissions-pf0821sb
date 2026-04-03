class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int res = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] pre: prerequisites) {
            indegree[pre[0]]++;
            graph.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            res++;
            List<Integer> neighbors = graph.get(cur);
            
                for(int neighbor: neighbors) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        q.offer(neighbor);
                    }
                }
            
        }
        return res == numCourses;
    }
}
