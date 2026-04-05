class Solution {
    int[] memo;
    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(s, 0);
    }
    private int dfs(String s, int idx) {
        if (idx == s.length()) return 1;
        if (s.charAt(idx) == '0') return 0;
        if (memo[idx] != -1) return memo[idx];
        int res = dfs(s, idx + 1);
        if (idx + 1 < s.length() && (s.charAt(idx) == '1' || 
        (s.charAt(idx) == '2' && s.charAt(idx + 1) <= '6'))) {
            res += dfs(s, idx + 2);
        }
        memo[idx] = res;
        return res;
    }
}
