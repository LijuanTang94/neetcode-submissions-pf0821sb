class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0;
        int freq = 0;
        int max = 0;
        for(int r = 0; r < s.length(); r++) {
            char a = s.charAt(r);
            count[a - 'A']++;
            freq = Math.max(freq, count[a - 'A']);
            if (r - l + 1 - freq > k) {
                char b = s.charAt(l);
                count[b - 'A']--;
                l++;
            }
            max = Math.max(max, r - l + 1);

        }
        return max;
    }
}
