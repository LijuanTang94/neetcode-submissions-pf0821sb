class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for(char a: t.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for(int r = 0, l = 0; r < s.length(); r++) {
            char b = s.charAt(r);
            if (map.containsKey(b)) {
                map.put(b, map.get(b) - 1);
                if (map.get(b).equals(0)) {
                    valid++;
                }
            }
            while (map.size() == valid) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }
                 char c = s.charAt(l);
                if (map.containsKey(c)) {
                    if (map.get(c).equals(0)) {
                        valid--;
                    }
                    map.put(c, map.get(c) + 1);
                }
                l++;
            }

        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
