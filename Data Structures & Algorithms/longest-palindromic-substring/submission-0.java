class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            String res1 = f(s, i, i);
            if (res1.length() > res.length()) res = res1;
            String res2 = f(s, i, i + 1);
            if (res2.length() > res.length()) res = res2;
        }
        return res;
    }
    private String f(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
