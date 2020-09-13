class Solution {
	/**
	 * 注意进位
	 */
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i > -1; i--) {
            digits[i] += 1;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[length + 1];
        digits[0] = 1;
        return digits;
    }
}