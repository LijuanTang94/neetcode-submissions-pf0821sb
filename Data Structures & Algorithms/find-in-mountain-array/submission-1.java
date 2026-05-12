/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 0, r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (m + 1 < n && mountainArr.get(m) > mountainArr.get(m + 1)) {
                r = m;
            } else {
                l = m + 1;
            } 
        }
        int res = f(target, mountainArr, 0, l);
        return res != -1 ? res : g(target, mountainArr, l + 1, n - 1);

    }
    private int f(int target, MountainArray mountainArr, int l, int r) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            int res = mountainArr.get(m);
            if (res == target) {
                return m;
            } else if (res < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    private int g(int target, MountainArray mountainArr, int l, int r) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            int res = mountainArr.get(m);
            if (res == target) {
                return m;
            } else if (res < target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }


    
}