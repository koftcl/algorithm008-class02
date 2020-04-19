import org.junit.Test;

public class LeetCode26 {
    @Test
    public void name() {
        int[] nums = new int[]{1,1,2};
        System.out.println(removeDuplicates(nums));
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }
            nums[count] = nums[i];
            count++;
        }
        return count;
    }
}
