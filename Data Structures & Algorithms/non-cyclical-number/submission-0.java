class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (n != 1) {
            if (visited.contains(n)) {
                return false;
            }
            visited.add(n);
            n = f(n);
        }
        return true;
    }
    private int f(int n) {
        int sum = 0;
        while (n > 0) {
            int num = n % 10;
            sum += num * num;
            n = n / 10;
        }
        return sum;
    }
}
