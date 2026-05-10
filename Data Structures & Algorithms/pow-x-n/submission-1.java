class Solution {
    public double myPow(double x, int n) {
        return f(x, n);
    }
    private double f(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) return (1.0 / f(x, -(long)n));
        double res = f(x, n / 2);
        if (n % 2 != 0) {
            return res * res * x;
        } else {
            return res * res;
        }
    }
    
}
