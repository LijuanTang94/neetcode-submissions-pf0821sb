class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;
        for(int r = 0, l = 0; r < s.length(); r++) {
            char a = s.charAt(r);
            map.put(a, map.getOrDefault(a, 0) + 1);
            while (map.get(a) > 1) {
                char b = s.charAt(l);
                map.put(b, map.get(b) - 1);
                l++;
            }
            len = Math.max(len, r - l + 1);
        }
        return len;
    }
}
