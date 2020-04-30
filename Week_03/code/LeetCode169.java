import org.junit.Test;

import java.util.Arrays;

public class LeetCode169 {
    @Test
    public void name() {
        System.out.println(majorityElement(new int[]{3, 4, 4}));
    }

    public int majorityElement(int[] nums) {
        return helper(nums);
    }

    private Integer helper(int[] nums) {
        if (nums.length == 1) return nums[0];

        Integer left = helper(Arrays.copyOfRange(nums, 0, nums.length / 2));
        Integer right = helper(Arrays.copyOfRange(nums, nums.length / 2, nums.length));

        if (left == null) return right;
        if (right == null) return left;
        if (left.equals(right)) return left;
        return null;
    }
}
