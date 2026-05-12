class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x <= 2) return 1;
        int l = 0, r = x / 2;
        while (l <= r) {
            int m = l + (r - l) / 2;
            long res = (long)m * m;
            if (res == x) {
                return m;
            } else if (res < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }
}