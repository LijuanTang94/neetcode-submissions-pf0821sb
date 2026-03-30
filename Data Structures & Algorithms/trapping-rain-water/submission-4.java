class Solution {
    public int trap(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        int lmax = 0;
        int rmax = 0;
        int res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                lmax = Math.max(lmax, height[l]);
                res += lmax - height[l++];
            } else {
                rmax = Math.max(rmax, height[r]);
                res += rmax - height[r--];
            }
        }
        return res;
    }
}
