class Solution {
    public String minWindow(String s, String t) {
        int len = Integer.MAX_VALUE;
        int start = 0;
        int valid = 0;
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for(char a: t.toCharArray()) {
            need.put(a, need.getOrDefault(a, 0) + 1);
        }
        for(int r = 0, l = 0; r < s.length(); r++) {
            char b = s.charAt(r);
            if (need.containsKey(b)) {
                window.put(b, window.getOrDefault(b, 0) + 1);
                if (window.get(b).equals(need.get(b))) {
                    valid++;
                }
            }
            while (need.size() == valid) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }
                char c = s.charAt(l);
                if (need.containsKey(c)) {
                    if (window.get(c).equals(need.get(c))) {
                        valid--;
                    }
                    window.put(c, window.get(c) - 1);
                }
                l++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
