package prepare;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 * 2020/04/28
 * 2020/04/30
 */
public class LeetCode50 {
    @Test
    public void name() {

    }

    /**
     * 分治
     */
    public double myPow(double x, int n) {
        long nn = n;
        if (nn < 0) {
            nn = -nn;
            x = 1 / x;
        }
        return helper(x, nn);
    }

    public double helper(double x, long n) {
        // terminator
        if (n == 0) return 1.0;

        // process
        // drill down
        double tmp = helper(x, n / 2);

        // merge
        if (n % 2 == 1) {
            return tmp * tmp * x;
        } else {
            return tmp * tmp;
        }
    }
}
