class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for(int p: piles) {
            r = Math.max(p, r);
        }
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (getTime(piles, m) <= h) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    private long getTime(int[] piles, int k) {
        long sum = 0;
        for(int p: piles) {
            sum += (long)p / k;
            if (p % k != 0) {
                sum += 1;
            }
        }
        return sum;
    }
}
