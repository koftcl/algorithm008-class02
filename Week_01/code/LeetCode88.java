import org.junit.Test;

public class LeetCode88 {

    @Test
    public void name() {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};
        merge(nums1, 1, nums2, 0);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;
        while (k >= 0) {
            if (j < 0 || (i >= 0 && nums1[i] > nums2[j])) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}
