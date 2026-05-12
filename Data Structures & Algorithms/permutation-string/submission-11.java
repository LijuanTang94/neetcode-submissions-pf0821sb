class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] count = new int[26];
        for(char a: s1.toCharArray()) {
            count[a - 'a']++;
        }
        int l = 0;
        int[] need = new int[26];
        for(int r = 0; r < s2.length(); r++) {
            need[s2.charAt(r) - 'a']++;
            if (r - l + 1 > s1.length()) {
                need[s2.charAt(l) - 'a']--;
                l++;
            }
            if (Arrays.equals(count, need)) return true;
        }
        return false;
    }
}
