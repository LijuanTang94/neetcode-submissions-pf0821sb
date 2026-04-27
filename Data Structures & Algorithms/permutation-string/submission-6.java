class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] need = new int[26];
        int[] window = new int[26];
        int k = s1.length();
        for(char a: s1.toCharArray()) {
            need[a - 'a']++;
        }
        for(int r = 0, l = 0; r < s2.length(); r++) {
            char b = s2.charAt(r);
            window[b - 'a']++;
            if (r >= k) {
                window[s2.charAt(l) - 'a']--;
                l++;
            }
            if (r >= k - 1 && Arrays.equals(window, need)) {
                return true;
            }
        }
        return false;
    }
}
