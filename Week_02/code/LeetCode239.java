import org.junit.Test;

import java.util.LinkedList;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/solution/
 * 2020/04/22
 */
public class LeetCode239 {

    @Test
    public void name() {

        for (int i = 0; i < 10; i++) {
            map.put(new Random().nextInt(), 1);
        }
        System.out.println(map.lastKey());
        for (Integer integer : map.keySet()) {
            System.out.println(integer);
        }
    }

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr = new int[nums.length - k + 1];
        int i = 0, j = k - 1, cur = 0;
        for (int l = 0; l < k; l++) {
            append(nums[l]);
        }
        arr[cur] = map.lastKey();
        cur++;

        while (j < nums.length) {
            remove(nums[i]);
            append(nums[j]);
            arr[cur] = map.lastKey();
            j++;
            i++;
            cur++;
        }

        return arr;
    }

    private void append(int i) {
        if (map.containsKey(i)) {
            map.put(i, map.get(i)+1);
            return;
        }
        map.put(i, 1);
    }

    private void remove(int i) {
        int tmp = map.get(i) - 1;
        if (tmp > 0) {
            map.put(i, tmp);
        } else {
            map.remove(i);
        }
    }
}
