class Solution {
    Set<Integer> set;
    List<List<Integer>> graph;
    public boolean validTree(int n, int[][] edges) {
        set = new HashSet<>();
        graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return dfs(0, - 1) && n == set.size();
    }   
    private boolean dfs(int i, int prev) {
        if (set.contains(i)) return false;
        set.add(i);
        for(int neighbor: graph.get(i)) {
            if (neighbor == prev) continue;
            if (!dfs(neighbor, i)) return false;
        }
        return true;
    }
}
