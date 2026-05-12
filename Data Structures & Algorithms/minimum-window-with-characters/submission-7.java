class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[128];
        int need = 0;
        for(char a: t.toCharArray()) {
            if (count[a] == 0) {
                need++;
            }
            count[a]++;
        }
        int l = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        for(int r = 0; r < s.length(); r++) {
            count[s.charAt(r)]--;
            if (count[s.charAt(r)] == 0) need--;
            while (need == 0) {
                if (r - l + 1 < min) {
                    min = r - l + 1;
                    start = l;
                }
                if (count[s.charAt(l)] == 0) need++;
                count[s.charAt(l)]++;
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
