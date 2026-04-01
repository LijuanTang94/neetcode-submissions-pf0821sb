class Solution {
    List<List<String>> res;
    List<String> path;
    public List<List<String>> partition(String s) {
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
            if (isValid(s, start, end)) {
                path.add(s.substring(start, end + 1));
                dfs(s, end + 1);
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean isValid(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
