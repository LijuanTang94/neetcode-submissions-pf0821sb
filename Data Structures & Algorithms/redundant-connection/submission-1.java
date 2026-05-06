class Solution {
    class UnionFind {
        int[] parent;
        int[] rank;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        private boolean union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            if (parentA == parentB) return false;
            if (rank[parentA] > rank[parentB]) {
                parent[parentB] = parentA;
                rank[parentA] += rank[parent[parentB]];
            } else {
                parent[parentA] = parentB;
                rank[parentB] += rank[parent[parentA]];
            }
            return true;
        }
        private int find(int a) {
            if (parent[a] != a) {
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind u = new UnionFind(n + 1);
        for(int[] edge: edges) {
            if (!u.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[] {};
    }
}
