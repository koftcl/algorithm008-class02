import org.junit.Test;

public class LeetCode258 {

    @Test
    public void name() {

    }

    /**
     * 递归
     */
    public int addDigits(int num) {
        int sum = 0, tmp = num;
        while (tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        if (num < 10) return sum;
        return addDigits(sum);
    }

    /**
     * 迭代
     */
    public int addDigits1(int num) {
        while (num > 9) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}
