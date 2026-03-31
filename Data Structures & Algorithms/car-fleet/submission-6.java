class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++) {
            pairs[i] = new int[] {position[i], speed[i]};
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        double[] time = new double[n];
        for(int i = 0; i < n; i++) {
            time[i] = (double)(target - pairs[i][0]) / pairs[i][1];
        }
        Stack<Double> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            if (!stack.isEmpty() && time[i] <= stack.peek()) {
                continue;
            }
            stack.push(time[i]);
        }
        return stack.size();
    }
}
