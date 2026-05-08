class Solution {
    Map<String, Boolean> map;
    public boolean isInterleave(String s1, String s2, String s3) {
        map = new HashMap<>();
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) return false;
        return dfs(s1, s2, s3, 0, 0);
    }
    private boolean dfs(String s1, String s2, String s3, int i, int j) {
        if (i == s1.length() && j == s2.length()) return true;
        String key = i + "," + j;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            res |= dfs(s1, s2, s3, i + 1, j);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            res |= dfs(s1, s2, s3, i, j + 1);
        }
        map.put(key, res);
        return res;

    }
}
