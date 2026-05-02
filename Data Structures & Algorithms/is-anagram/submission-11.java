class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for(char a: s.toCharArray()) {
            count[a - 'a']++;
        }
        for(char b: t.toCharArray()) {
            count[b - 'a']--;
        }
        for(int c: count) {
            if (c != 0) return false;
        }
        return true;
    }
}
