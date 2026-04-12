class Solution {
    Map<String, Integer> map;
    public int numDistinct(String s, String t) {
        map = new HashMap<>();
        return dfs(s, t, 0, 0);
    }
    private int dfs(String s, String t, int i, int j) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }  
        String temp = i + "," + j;
        if (map.containsKey(temp)) {
            return map.get(temp);
        }
        int cur = 0;
        
        cur += dfs(s, t, i + 1, j);
        if (s.charAt(i) == t.charAt(j)) {
            cur += dfs(s, t, i + 1, j + 1);
        }
        map.put(temp, cur);
        return cur;
    }
}
