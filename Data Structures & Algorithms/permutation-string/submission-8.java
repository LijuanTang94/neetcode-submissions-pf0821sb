class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int valid = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char a: s1.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for(int r = 0, l = 0; r < s2.length(); r++) {
            char b = s2.charAt(r);
            if (map.containsKey(b)) {
                map.put(b, map.get(b) - 1);
                if (map.get(b).equals(0)) {
                    valid++;
                }
            }
            while (map.size() == valid) {
                if (r - l + 1 == s1.length()) {
                    return true;
                }
                char c = s2.charAt(l);
                if (map.containsKey(c)) {
                    if (map.get(c).equals(0)) {
                        valid--;
                    }
                    map.put(c, map.get(c) + 1);
                }
                l++;
            }
        }
        return false;
    }
}
