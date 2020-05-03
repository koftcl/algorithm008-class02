import org.junit.Test;

import java.util.*;

/**
 * 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 * 2020/05/02
 */
public class LeetCode47 {
    @Test
    public void name() {
        int[] nums = new int[]{1,1,3};
        List<List<Integer>> ans = permuteUnique(nums);
        for (List<Integer> an : ans) {
            System.out.println(an);
        }
    }

    /**
     * 回溯 + 剪枝
     * T O(n*n!)
     * S O(n)
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (nums == null || nums.length == 0) return ans;

        Arrays.sort(nums);
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

        for (int i = 0; i < nums.length; i++) {
            // 剪枝条件 !set.contains(i - 1) 需要注意
            if (i > 0 && nums[i - 1] == nums[i] && !set.contains(i - 1)) continue;
            int num = nums[i];
            if (set.add(i)) {
                curr.add(num);
                backTrack(ans, curr, nums, set);
                curr.pollLast();
                set.remove(i);
            }
        }
    }
}
