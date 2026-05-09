class Solution {
    Map<String, Integer> map;
    public int numDistinct(String s, String t) {
        map = new HashMap<>();
        if (s.length() < t.length()) return 0;
        return dfs(s, t, 0, 0);
    }
    private int dfs(String s, String t, int i, int j) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;
        String key = i + "," + j;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int res = 0;
        res += dfs(s, t, i + 1, j);
        if (s.charAt(i) == t.charAt(j)) {
            res += dfs(s, t, i + 1, j + 1);
        }
        map.put(key, res);
        return res;
    }
}
