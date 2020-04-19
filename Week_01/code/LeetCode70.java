import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LeetCode70 {

    private Map<Integer, Integer> cache = new HashMap<>();

    @Test
    public void name() {
        System.out.println(climbStairs(5));
    }

    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        // containsKey() 方法
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int result = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, result);

        return result;
    }
}
