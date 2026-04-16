class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i = n - 1;
        while (i >= 0) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
                i--;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[n + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
