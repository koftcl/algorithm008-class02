import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 全排列
 * https://leetcode-cn.com/problems/permutations/
 * 2020/05/02
 */
public class LeetCode46 {
    @Test
    public void name() {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> ans = permute(nums);
        for (List<Integer> an : ans) {
            System.out.println(an);
        }
    }

    /**
     * 回溯
     * T O(n*n!)
     * S O(n)
     */
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (nums == null || nums.length == 0) return ans;

        LinkedList<Integer> curr = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        backTrack(ans, curr, nums, set);

        return ans;
    }

    private void backTrack(LinkedList<List<Integer>> ans, LinkedList<Integer> curr, int[] nums, HashSet<Integer> set) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int num : nums) {
            if (set.add(num)) {
                curr.add(num);
                backTrack(ans, curr, nums, set);
                curr.pollLast();
                set.remove(num);
            }
        }
    }
}
