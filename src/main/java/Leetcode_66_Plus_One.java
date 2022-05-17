public class Leetcode_66_Plus_One {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] = (digits[digits.length - 1] + 1) % 10;
        if (digits[digits.length - 1] == 0) {
            for (int i = digits.length - 2; i >= 0; i--) {
                digits[i] = (digits[i] + 1) % 10;
                if (digits[i] != 0) {
                    return digits;
                }
            }

            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < digits.length + 1; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        } else {
            return digits;
        }
    }
}
