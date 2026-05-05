class Solution {
    List<String> res;
    StringBuilder sb;
    String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        backtrack(digits, 0);
        return res;
    }
    private void backtrack(String digits, int start) {
        if (digits == null || digits.length() == 0) {
            return;
        }
        if (start == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int idx = digits.charAt(start) - '0';
        String str = strs[idx];
        for(int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtrack(digits, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
