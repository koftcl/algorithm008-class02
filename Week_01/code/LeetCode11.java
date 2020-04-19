import org.junit.Test;

public class LeetCode11 {
    @Test
    public void name() {
        int[] height = {2, 3, 4, 5, 18, 17, 6};
        System.out.println(maxArea(height));
    }

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int head = 0, tail = height.length - 1, vol = 0;
        while (head != tail) {
            // 计算体积
            int tmp = (tail - head) * Integer.min(height[head], height[tail]);

            // 比较体积移动指针
            if (height[head] > height[tail]) {
                tail--;
            } else {
                head++;
            }
            if (tmp < vol) continue;
            vol = tmp;
        }
        return vol;
    }
}
