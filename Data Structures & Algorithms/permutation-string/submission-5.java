class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for(int i = 0; i < 26; i++) {
            if (c1[i] == c2[i]) matches++;
        }
        for(int r = s1.length(), l = 0; r < s2.length(); r++) {
            if (matches == 26) return true;
            int idx = s2.charAt(r) - 'a';
            if (c1[idx] == c2[idx]) matches--;
            if (c1[idx] == ++c2[idx]) matches++;
            int idx1 = s2.charAt(l++) - 'a';
            if (c1[idx1] == c2[idx1]) matches--;
            if (c1[idx1] == --c2[idx1]) matches++;
        }
        return matches == 26;

    }
}
