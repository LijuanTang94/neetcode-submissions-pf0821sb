class Solution {
    List<List<String>> res;
    List<String> path;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        backtrack(s, 0);
        return res;
    }
    private void backtrack(String s, int i) {
        if (i == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int j = i; j < s.length(); j++) {
            if (check(s, i, j)) {
                path.add(s.substring(i, j + 1));
                backtrack(s, j + 1);
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean check(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
