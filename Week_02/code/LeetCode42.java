import org.junit.Test;

import java.util.LinkedList;

/**
 * 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class LeetCode42 {
    @Test
    public void name() {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public int trap(int[] height) {

        int len = height.length;
        int index = 0, max = 0;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        while (index < len) {
            max = Math.max(max, height[index]);
            leftMax[index] = max;
            index++;
        }

        index = len - 1;
        max = 0;
        while (index >= 0) {
            max = Math.max(max, height[index]);
            rightMax[index] = max;
            index--;
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            count += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return count;
    }
}
