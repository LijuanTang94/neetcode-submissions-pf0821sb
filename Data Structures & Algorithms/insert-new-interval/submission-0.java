class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) return new int[][]{newInterval};
        int i = 0;
        int n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }
        int start = newInterval[0];
        int end = newInterval[1];
        while (i < n && intervals[i][0] <= newInterval[1]) {
            end = Math.max(intervals[i][1], end);
            start = Math.min(intervals[i][0], start);
            i++;
        }
        res.add(new int[]{start, end});
        while (i < n) {
            res.add(intervals[i++]);
        }
        return res.toArray(new int[0][]);
    }
}
