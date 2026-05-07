class Solution {
    Set<String> set;
    Map<Integer, Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        set = new HashSet<>(wordDict);
        return check(s, 0);
    }
    private boolean check(String s, int start) {
        if (start == s.length()) return true;
        if (map.containsKey(start)) return map.get(start);
        boolean res = false;
        for (int j = start + 1; j <= s.length(); j++) {
            if (set.contains(s.substring(start, j)) && check(s, j)) {
                res = true;
            }
        }
        map.put(start, res);
        return res;
    }
}
