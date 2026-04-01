class Solution {
    List<String> res;
    StringBuilder sb;
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        if (digits.length() == 0) return res;
        dfs(digits, 0);
        return res;
    }
    private void dfs(String digits, int start) {
        if (start == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int idx = digits.charAt(start) - '0';
        String words = map[idx];
        for(int i = 0; i < words.length(); i++) {
            sb.append(words.charAt(i));
            dfs(digits, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
