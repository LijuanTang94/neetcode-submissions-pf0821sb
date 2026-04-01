class Solution {
    List<List<String>> res;
    List<String> path;
    boolean[][] isPalin;
    public List<List<String>> partition(String s) {
        int n = s.length();
        isPalin = new boolean[n][n];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1 || isPalin[i + 1][j - 1]) {
                        isPalin[i][j] = true;
                    }
                }
            }
        }
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(s, 0);
        return res;
    }
    private void dfs(String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int end = start; end < s.length(); end++) {
            if (isPalin[start][end]) {
                path.add(s.substring(start, end + 1));
                dfs(s, end + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
