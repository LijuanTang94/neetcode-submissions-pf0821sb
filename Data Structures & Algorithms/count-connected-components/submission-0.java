class Solution {
    int res = 0;
    Set<Integer> set;
    List<List<Integer>> graph;
    public int countComponents(int n, int[][] edges) {
        graph = new ArrayList<>();
        set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        for(int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                res++;
                dfs(i);
            }
        }
        return res;
    }
    private void dfs(int i) {
        set.add(i);
        for(int neighbor: graph.get(i)) {
            if (!set.contains(neighbor)) dfs(neighbor);
        }
    }
}
