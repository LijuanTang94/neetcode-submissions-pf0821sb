class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int freq = 0;
        int len = 0;
        for(int r = 0, l = 0; r < s.length(); r++) {
            char a = s.charAt(r);
            map.put(a, map.getOrDefault(a, 0) + 1);
            freq = Math.max(freq, map.get(a));
            if (r - l + 1 - freq > k) {
                char b = s.charAt(l);
                map.put(b, map.get(b) - 1);
                l++;
            }
            len = Math.max(len, r - l + 1);
        }
        return len;
    }
}
