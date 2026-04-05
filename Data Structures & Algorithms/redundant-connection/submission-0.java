class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for(int[] edge: edges) {
            if (!union(edge[0], edge[1])) return edge;
        }
        return new int[]{};
    }
    private int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
    private boolean union(int x, int y) {
        int a = find(x), b = find(y);
        if (a == b) return false;
        parent[a] = b;
        return true;
    }
}
