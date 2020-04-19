import org.junit.Test;

import java.util.LinkedList;

public class LeetCode42 {
    @Test
    public void name() {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int len = height.length;
        int top = 1, count = 0, tmp = 0, L = 0, R = len - 1;

        while (L <= R) {
            while (L <= R && height[L] < top) {
                count += height[L];
                L++;
            }
            while (R >= L && height[R] < top) {
                count += height[R];
                R--;
            }
            top++;
            tmp += R-L+1;
        }

        return tmp - count;
    }
}
