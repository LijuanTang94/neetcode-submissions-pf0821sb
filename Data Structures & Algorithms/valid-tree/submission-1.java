class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        UnionFind u = new UnionFind(n);
        for(int[] edge: edges) {
            if (!u.union(edge[0], edge[1])) {
                return false;
            }
        }
        return true;
    }
    class UnionFind{
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        private boolean union(int a, int b) {
            int parentA = findParent(a);
            int parentB = findParent(b);
            if (parentA == parentB) return false;
            parent[parentA] = parentB;
            return true;
        }
        private int findParent(int a) {
            if (parent[a] != a) {
                parent[a] = findParent(parent[a]);
            }
            return parent[a];
        }
    }
}
