class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        for(char a: s1.toCharArray()) {
            count[a - 'a']++;
        }
        for(int r = 0, l = 0; r < s2.length(); r++) {
            char b = s2.charAt(r);
            count[b - 'a']--;
            while (count[b - 'a'] < 0) {
                count[s2.charAt(l) - 'a']++;
                l++;
            }
            if (r - l + 1 == s1.length()) {
                return true;
            }
        }
        return false;
    }
}
