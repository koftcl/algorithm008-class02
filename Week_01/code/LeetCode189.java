import org.junit.Test;

public class LeetCode189 {
    @Test
    public void name() {
        int[] nums = new int[]{1,1,2};
        rotate(nums, 2);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (nums == null || k == 0) return;
        int tmp1 = nums[0], tmp2 = 0, index = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            index += k;
            index = index % nums.length;
            tmp2 = nums[index];
            nums[index] = tmp1;
            tmp1 = tmp2;
            if (index == start) {
                index++;
                start++;
                tmp1 = nums[index];
            }
        }
    }
}
