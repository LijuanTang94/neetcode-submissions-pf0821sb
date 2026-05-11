class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            int len = str.length();
            sb.append(len).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '#') {
                int len = Integer.valueOf(str.substring(j, i));
                i = i + 1; // new String start index
                res.add(str.substring(i, i + len));
                i = i + len;
                j = i;
            }
            i++;
        }
        return res;
    }
}
