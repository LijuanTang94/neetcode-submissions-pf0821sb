class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for(int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) matches++;
        }
        for(int r = s1.length(), l = 0; r < s2.length(); r++) {
            if (matches == 26) return true;
            int idx1 = s2.charAt(r) - 'a';
            if (count2[idx1] == count1[idx1]) matches--;
            count2[idx1]++;
            if (count2[idx1] == count1[idx1]) {
                matches++;
            }
            int idx2 = s2.charAt(l++) - 'a';
            if (count2[idx2] == count1[idx2]) matches--;
            count2[idx2]--;
            if (count2[idx2] == count1[idx2]) {
                matches++;
            }
        }
        return matches == 26;

    }
}
