import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 * 2020/04/30 哈希
 * 2020/05/01 排序、分治
 */
public class LeetCode169 {
    @Test
    public void name() {
        System.out.println(majorityElement3(new int[]{8,9,8,9,8}));
    }

    /**
     * 投票法
     * O(n)
     */
    public int majorityElement3(int[] nums) {
        int count = 0, tmp = 0;
        for (int num : nums) {
            if (count == 0) tmp = num;
            if (num == tmp) count++;
            else count--;
        }
        return tmp;

    }

    /**
     * 分治
     * 时间复杂度O(nlogn)
     */
    public int majorityElement2(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int lo, int hi) {
        if (lo == hi) return nums[lo];

        int mid = (hi - lo) / 2 + lo;
        int left = helper(nums, lo, mid);
        int right = helper(nums, mid + 1, hi);

        if (left == right) return left;

        if (count(nums, lo, hi, left) > count(nums, lo, hi, right)) {
            return left;
        } else {
            return right;
        }
    }

    private int count(int[] nums, int lo, int hi, int index) {
        int count = 0;
        // 需要用 <=
        while (lo <= hi) {
            if (index == nums[lo]) count++;
            lo++;
        }
        return count;
    }

    /**
     * 排序
     * 时间复杂度O(nlogn)
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 哈希表
     * 时间复杂度O(n)
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i: nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int max = 0, index = 0;

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                index = entry.getKey();
            }
        }
        return index;
    }
}
