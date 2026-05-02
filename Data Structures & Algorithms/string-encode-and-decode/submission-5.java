class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            int len = str.length();
            sb.append(len);
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> arr = new ArrayList<>();
        int i = 0;
        int j = i;
        while (i < str.length()) {
            while (str.charAt(i) != '#') {
                i++;
            }
            int len = Integer.parseInt(str.substring(j, i));
            i++;
            arr.add(str.substring(i, i + len));
            i = i + len;
            j = i;
        }
        return arr;
    }
}
