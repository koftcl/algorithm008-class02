import org.junit.Test;

import java.util.*;

/**
 * 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 2020/04/25
 */
public class LeetCode347 {
    @Test
    public void name() {

    }

    /**
     * 使用map统计，二叉堆排出前k
     * 时间复杂度： O(NlogK)
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(map.size(), (o1, o2) -> o2.getValue() - o1.getValue());
        heap.addAll(map.entrySet());

        int[] ans = new int[Math.max(k, map.size())];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = heap.poll();
            if (entry == null) {
                break;
            }
            ans[i] = entry.getKey();
        }

        return ans;
    }
}
