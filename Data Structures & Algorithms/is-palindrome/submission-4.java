class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char a: s.toCharArray()) {
            if (Character.isLetterOrDigit(a)) {
                sb.append(Character.toLowerCase(a));
            }
        }
        String s1 = sb.toString();
        int l = 0, r = s1.length() - 1;
        while (l <= r) {
            if (s1.charAt(l) != s1.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
