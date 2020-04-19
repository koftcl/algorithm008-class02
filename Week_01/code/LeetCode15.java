import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode15 {
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

    public List<List<Integer>> threeSum(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return result;
            }

            // 不加这段会出现重复组合
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int curr = nums[i];
            int L = i + 1, R = length - 1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if (tmp == 0) {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    result.add(list);

                    while (L < R && nums[L] == nums[L+1]) ++L;
                    while (L < R && nums[R] == nums[R-1]) --R;
                    ++L;
                    --R;
                } else if (tmp > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }

        return result;
    }
}
