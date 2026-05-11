class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            if (heights[l] < heights[r]) {
                max = Math.max(max, (r - l) * heights[l]);
                l++;
            } else {
                max = Math.max(max, (r - l) * heights[r]);
                r--;
            }
        }
        return max;
    }
}
