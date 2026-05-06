class Solution {
    Map<Integer, Integer> map;
    public int numDecodings(String s) {
        map = new HashMap<>();
        return dfs(s, 0);
    }
    private int dfs(String s, int idx) {
        if (idx == s.length()) return 1;
        if (s.charAt(idx) == '0') return 0;
        if (map.containsKey(idx)) return map.get(idx);
        int res = dfs(s, idx + 1);
        if (idx + 1 < s.length() &&
        (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx + 1) <= '6'))){
            res += dfs(s, idx + 2);
        }
        map.put(idx, res);
        return res;
    }
}
