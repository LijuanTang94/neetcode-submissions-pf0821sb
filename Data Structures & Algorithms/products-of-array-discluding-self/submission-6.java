class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preProduct = new int[n];
        preProduct[0] = 1;
        for(int i = 1; i < n; i++) {
            preProduct[i] = preProduct[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int i = n - 2; i >= 0; i--) {
            right *= nums[i + 1];
            preProduct[i] *= right;
        }
        return preProduct;
    }
}  
