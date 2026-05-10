class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int n = intervals.length;
        int start = intervals[0][0];
        int end = intervals[0][1];
        int res = 0;
        for(int i = 1; i < n; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
            } else {    
                res++;
                end = Math.min(end, intervals[i][1]);
            }
        }
        return res;
    }
}
