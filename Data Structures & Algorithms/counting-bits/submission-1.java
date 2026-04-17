class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            res[i] = count(i);
        }
        return res;
    }
    private int count(int n) {
        int total = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                total++;
            }
            n >>>= 1;
        }
        return total;
    }
}
