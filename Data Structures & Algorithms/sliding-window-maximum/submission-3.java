class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr = new int[nums.length - k + 1];
        int idx = 0;
        Deque<Integer> dq = new LinkedList<>();
        for(int r = 0, l = 0; r < nums.length; r++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[r]) {
                dq.pollLast();
            }
            dq.offer(r);
            if (r >= k) l++;
            if (l > dq.peekFirst()) {
                dq.pollFirst();
            }
            if (r >= k - 1) {
                arr[idx++] = nums[dq.peekFirst()]; 
            }
        }
        return arr;
    }
}
