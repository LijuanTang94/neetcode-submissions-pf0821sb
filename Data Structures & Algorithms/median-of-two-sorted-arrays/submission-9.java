class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            return (findMedian(nums1, 0, nums2, 0, mid) + findMedian(nums1, 0, nums2, 0, mid + 1)) / 2.0;
        } else {
            return findMedian(nums1, 0, nums2, 0, mid + 1);
        }
    }
    private double findMedian(int[] a, int i, int[] b, int j, int k) {
        if (i >= a.length) return b[j + k - 1];
        if (j >= b.length) return a[i + k - 1];
        if (k == 1) return Math.min(a[i], b[j]);
        int half = k / 2;
        int val1 = i + half - 1 > a.length ? Integer.MAX_VALUE : a[i + half - 1];
        int val2 = j + half - 1 > b.length ? Integer.MAX_VALUE : b[j + half - 1];
        if (val1 <= val2) {
            return findMedian(a, i + half, b, j, k - half);
        } else {
            return findMedian(a, i, b, j + half, k - half);
        }
    }
}
