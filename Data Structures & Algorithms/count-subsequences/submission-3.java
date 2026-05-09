class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) return 0;
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[m][n] = 1;
        for(int i = m; i >= 0; i--) {
            for(int j = n; j >= 0; j--) {
                if (j == n) {
                    dp[i][j] = 1;
                    continue;
                }else if (i == m) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == m && j == n) continue;
                dp[i][j] += dp[i + 1][j];
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
