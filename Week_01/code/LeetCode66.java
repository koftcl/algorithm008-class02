public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index >= 0) {
            digits[index]++;
            digits[index] = digits[index] % 10;
            if (digits[index--] != 0) return digits;
        }
        digits = new int[digits.length+1];
        digits[0] = 1;

        return digits;
    }
}
