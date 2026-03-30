class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[128];
        int max = 0;
        for(int r = 0, l = 0; r < s.length(); r++) {
            count[s.charAt(r)]++;
            while (count[s.charAt(r)] > 1) {
                count[s.charAt(l)]--;
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
