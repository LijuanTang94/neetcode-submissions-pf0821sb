class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] newHeight = new int[n + 2];
        for(int i = 0; i < n; i++) {
            newHeight[i + 1] = heights[i];
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max = 0;
        for(int i = 1; i < n + 2; i++) {
            while (!stack.isEmpty() && newHeight[i] < newHeight[stack.peek()]) {
                int height = newHeight[stack.pop()];
                int width = i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }
}
