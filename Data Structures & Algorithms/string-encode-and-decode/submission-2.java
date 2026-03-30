class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            int len = str.length();
            sb.append(len + "#" + str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int r = 0;
        int l = 0;
        while (r < str.length()) {
            if (str.charAt(r) != '#') {
                r++;
                continue;
            }
            int len = Integer.parseInt(str.substring(l, r));
            res.add(str.substring(r + 1, r + len + 1));
            r = r + len + 1;
            l = r;
        }
        return res;
    }
}
