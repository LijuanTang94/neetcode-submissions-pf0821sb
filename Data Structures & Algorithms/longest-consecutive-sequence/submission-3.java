class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int num: nums) {
            set.add(num);
        }
        for(int n: set) {
            if (!set.contains(n - 1)) {
                int start = 0;
                while (set.contains(n)) {
                    start++;
                    n++;
                }
                max = Math.max(max, start);
            }
        }
        return max;
    }
}
