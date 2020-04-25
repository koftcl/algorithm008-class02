package prepare;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 2020/04/23
 * 2020/04/25
 */
public class Interview40 {
    @Test
    public void name() {

    }

    /**
     * 排序法
     * 时间复杂度： O(NlogN)
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        Arrays.sort(arr);
        System.arraycopy(arr, 0, result, 0, k);
        return result;
    }

    /**
     * 使用堆
     * 时间复杂度： O(NlogK)
     * 空间复杂大： O(N)
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        int[] ans = new int[k];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : arr) {
            heap.add(i);
        }

        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }

        return ans;
    }
}
