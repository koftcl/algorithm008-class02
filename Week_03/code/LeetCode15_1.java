import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * 2020/05/02
 */
public class LeetCode15_1 {
    @Test
    public void name() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        for (List<Integer> integers : threeSum(nums)) {
            for (Integer integer : integers) {
                System.out.print(integer);
                System.out.print(",");
            }
            System.out.println();
        }
    }

    /**
     * 双指针法
     * T O(n^2)
     * S O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 边界处理
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (nums.length < 3) return ans;

        // 排序 O(logn)
        Arrays.sort(nums);

        // 遍历 O(n)
        for (int i = 0; i < nums.length; i++) {
            // 剪枝1
            if (nums[i] > 0) break;
            // 剪枝2
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int left = i + 1, right = nums.length - 1;
            left = i + 1;
            // 双指针遍历 O(n)
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 符合条件加入结果
                    ans.add(Stream.of(nums[i], nums[left], nums[right]).collect(Collectors.toList()));
                    // 剪枝3
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // 剪枝4
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    // 同时移动双指针
                    left++;
                    right--;
                }
                // sum小于0移动左指针
                else if (sum < 0) left++;
                // sun大于0移动右指针
                else right--;
            }
        }

        return ans;
    }
}
