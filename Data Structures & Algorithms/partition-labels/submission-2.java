class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> idx = new ArrayList<>();
        int[] last = new int[26];
        for(int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int end = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (end == i) {
                idx.add(end - start + 1);
                start = i + 1;
            }
        }
        return idx;
    }
}
