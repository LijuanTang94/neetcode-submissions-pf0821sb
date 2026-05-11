class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        for(int j = 0; j < first.length(); j++) {
            for(String str: strs) {
                if (j == str.length() || first.charAt(j) != str.charAt(j)) {
                    return first.substring(0, j);
                }
            }
        }
        return first;
    }
}