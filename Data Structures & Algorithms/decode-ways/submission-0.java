class Solution {
    int[] dp;
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);
        return numCount(s, 0);
    }
    private int numCount(String s, int start) {
        if (start == s.length()) return 1;
        if (s.charAt(start) == '0') {
                return 0;
        }
        if (dp[start] != -1) return dp[start];
        int res = numCount(s, start + 1);
        if (start + 1 < s.length() && (s.charAt(start) == '1' || 
        (s.charAt(start) == '2') && s.charAt(start + 1) <= '6' )) {
            res += numCount(s, start + 2);
        }
        dp[start] = res;
        return res;
    }
}
