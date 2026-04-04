class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
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
            res.add(cur);
            for(int neighbor: graph.get(cur)) {
                if (--indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        if (res.size() != numCourses) return new int[]{};
        int[] arr = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
