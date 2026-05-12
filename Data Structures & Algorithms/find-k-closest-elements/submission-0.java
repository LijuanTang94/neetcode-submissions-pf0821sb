class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        r = l;
        l = r - 1;
        while (k > 0) {
            if (l < 0) {
                res.add(arr[r++]);
            } else if (r == arr.length) {
                res.add(arr[l--]);
            } else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                res.add(arr[l--]);
            } else {
                res.add(arr[r++]);
            }
            k--;
        }
        Collections.sort(res);
        return res;
    }
}