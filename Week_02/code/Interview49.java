import javafx.util.Pair;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 丑数
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 * 2020/04/26
 */
public class Interview49 {
    @Test
    public void name() {
        System.out.println(nthUglyNumber1(1352));
    }

    // 1 暴力法
    public int nthUglyNumber(int n) {
        int i = 1, count = 0;
        while (count < n) {
            int curr = i;
            while (curr % 2 == 0) curr /= 2;
            while (curr % 3 == 0) curr /= 3;
            while (curr % 5 == 0) curr /= 5;
            if (curr == 1) {
                count++;
            }
            i++;
        }
        return i-1;
    }

    // 2 2^a*3^b*5^c 递推
    public int nthUglyNumber1(int n) {
        if (n == 0) return 0;
        int[] arr = new int[n];
        arr[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int n2 = arr[a] * 2;
            int n3 = arr[b] * 3;
            int n5 = arr[c] * 5;
            arr[i] = Math.min(Math.min(n2, n3), n5);
            // 可能出现n2=n3=arr[i]
            if (n2 == arr[i]) a++;
            if (n3 == arr[i]) b++;
            if (n5 == arr[i]) c++;
        }
        return arr[n-1];
    }
}
