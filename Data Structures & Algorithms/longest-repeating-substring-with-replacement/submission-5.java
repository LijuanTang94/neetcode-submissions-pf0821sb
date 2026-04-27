class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int r = 0, l = 0; r < s.length(); r++) {
            char a = s.charAt(r);
            map.put(a, map.getOrDefault(a, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(a));
            if (r - l + 1 - k > maxFreq) {
                char b = s.charAt(l);
                map.put(b, map.get(b) - 1);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;

    }
}
