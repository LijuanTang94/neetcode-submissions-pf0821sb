class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[128];
        for(char a: t.toCharArray()) {
            count[a]++;
        }
        int need = t.length();
        int min = Integer.MAX_VALUE;
        int start = 0;
        for(int r = 0, l = 0; r < s.length(); r++) {
            if (count[s.charAt(r)] > 0) {
                need--;
            }
            count[s.charAt(r)]--;
            while (need == 0) {
                if (r - l + 1 < min) {
                    min = r - l + 1;
                    start = l;
                }
                count[s.charAt(l)]++;
                if (count[s.charAt(l)] > 0) {
                    need++;
                }
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
