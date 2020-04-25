import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 两个数组的交集 II
 *https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * 2020/04/21
 */
public class LeetCode350 {
    @Test
    public void name() {

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
                continue;
            }

            if (nums1[i] < nums2[j]) {
                i++;
                continue;
            }
            j++;
        }

        int[] result = new int[list.size()];
        for (int i1 = 0; i1 < list.size(); i1++) {
            result[i1] = list.get(i1);
        }

        return result;
    }
}
