class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[n - k + 1];
        for(int r = 0, l = 0; r < n; r++) {
            while (!dq.isEmpty() && dq.peekFirst() < l) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[r]) {
                dq.pollLast();
            }
            dq.offerLast(r);
            if (r >= k - 1) {
                res[l] = nums[dq.peekFirst()];
                l++;
            }
        }
        return res;

    }
}
