class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        int max = 0;
        for(int n: set) {
            if (!set.contains(n - 1)) {
                int count = 0;
                while (set.contains(n)) {
                    count++;
                    n = n + 1;
                }
                max = Math.max(max, count);
            }
            
        }
        return max;
    }
}
