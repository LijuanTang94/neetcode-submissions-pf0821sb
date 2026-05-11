class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[256];
        int l = 0;
        int max = 0;
        for(int r = 0; r < s.length(); r++) {
            char a = s.charAt(r);
            count[a]++;
            while (count[a] > 1) {
                char b = s.charAt(l);
                count[b]--;
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
