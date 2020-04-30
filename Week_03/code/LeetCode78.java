import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * https://leetcode-cn.com/problems/subsets/
 * 2020/04/30
 */
public class LeetCode78 {
    @Test
    public void name() {
        int[] nums = new int[]{1,2,3};
        System.out.println(subsets(nums));
    }

    List<List<Integer>> ans = new LinkedList<>();

    /**
     * 迭代
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for (int num : nums) {
            int size = ans.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = ans.get(i);
                List<Integer> newList = new ArrayList<>(list);
                newList.add(num);
                ans.add(newList);
            }
        }
        return ans;
    }

    /**
     * 递归
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return ans;
        }

        helper(nums, 0, new LinkedList<>());
        return ans;
    }

    private void helper(int[] nums, int i, LinkedList<Integer> list) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        helper(nums, i+1, list);
        list.add(nums[i]);
        helper(nums, i+1, list);

        list.pollLast();
    }
}
