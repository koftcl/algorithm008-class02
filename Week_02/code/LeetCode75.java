import org.junit.Test;

/**
 * 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 2020/04/26
 */
public class LeetCode75 {
    @Test
    public void name() {
        int[] nums = {1,2,0};
        sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void sortColors(int[] nums) {
        int cur = 0, L = 0, R = nums.length - 1;
        while (cur <= R) {
            if (nums[cur] == 0) {
                swp(nums, cur, L);
                L++;
                cur++;
                continue;
            }
            if (nums[cur] == 2) {
                swp(nums, cur, R);
                R--;
                continue;
            }
            cur++;
        }
    }

    private void swp(int[] nums, int i, int r) {
        int tmp = nums[i];
        nums[i] = nums[r];
        nums[r] = tmp;
    }
}
