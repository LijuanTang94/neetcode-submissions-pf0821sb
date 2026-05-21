class Solution {
    Map<Integer, Integer> map;
    public int numDecodings(String s) {
        map = new HashMap<>();
        return dfs(s, 0);
    }
    private int dfs(String s, int i) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (map.containsKey(i)) return map.get(i);
        int res = dfs(s, i + 1);
        if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
            res += dfs(s, i + 2);
        }
        map.put(i, res);
        return res;
    }
}
