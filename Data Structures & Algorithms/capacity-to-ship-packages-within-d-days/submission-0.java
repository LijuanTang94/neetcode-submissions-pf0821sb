class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = weights[0], r = 0;
        for(int w: weights) {
            l = Math.max(l, w);
            r += w;
        }
        while (l <= r) {
            int m = l + (r - l) / 2;
            long time = getTime(weights, m);
            if (time <= days) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    private long getTime(int[] weights, int cap) {
        long time = 1;
        int load = 0;
        for(int w: weights) {
            if (w + load <= cap) {
                load += w;
                continue;
            } 
            load = w;
            time++;
        }
        return time;
    }
}