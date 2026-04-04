class Solution {
    int[] state;
    List<Integer> res;
    List<List<Integer>> graph;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        state = new int[numCourses];
        res = new ArrayList<>();
        graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }
        for(int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && !dfs(i)) {
                return new int[]{};
            }
        }
        Collections.reverse(res);
        int[] arr = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            arr[i] = res.get(i);
        }
        return arr;

    }
    private boolean dfs(int i) {
        state[i] = 1;
        for(int neighbor: graph.get(i)) {
            if (state[neighbor] == 1) return false;
            if (state[neighbor] == 0 && !dfs(neighbor)) {
                return false;
            }
        }
        state[i] = 2;
        res.add(i);
        return true;
    }
}
