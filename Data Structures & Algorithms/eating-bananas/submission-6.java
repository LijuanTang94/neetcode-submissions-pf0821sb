class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1;
        for(int p: piles) {
            r = Math.max(r, p);
        }
        while (l <= r) {
            int m = l + (r - l) / 2;
            long time = getTime(piles, m);
            if (time > h) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
    private long getTime(int[] piles, int k) {
        long time = 0;
        for(int p: piles) {
            time += p / k;
            if (p % k != 0) {
                time++;
            }
        }
        return time;
    }
}
