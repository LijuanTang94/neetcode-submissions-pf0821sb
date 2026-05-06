class Solution {
    class UnionFind{ 
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
        private int union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            if (parentA == parentB) return 0;
            if (rank[parentA] > rank[parentB]) {
                parent[parentB] = parentA;
                rank[parentA] += rank[parentB];
            } else {
                parent[parentA] = parentB;
                rank[parentB] += rank[parentA];
            }
            return 1;
        }
        private int find(int a) {
            if (parent[a] != a) {
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }
    }
    public int countComponents(int n, int[][] edges) {
        UnionFind u = new UnionFind(n);
        int res = n;
        for(int[] edge: edges) {
            res -= u.union(edge[0], edge[1]);
        } 
        return res;
    }
}
