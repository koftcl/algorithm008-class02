package prepare;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class LeetCode54 {
    @Test
    public void name() {
        int[][] matrix = new int[2][1];
        matrix[0] = new int[]{3};
        matrix[1] = new int[]{2};
        spiralOrder(matrix);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> ans = new LinkedList<>();
        int n = matrix.length;
        if (n == 0) {
            return ans;
        }
        int m = matrix[0].length;
        int l1 = m - 1, l2 = n - 1, l3 = 0, l4 = 0, status = 0;
        int i = 0, j = 0;
        while (ans.size() < m * n) {
            ans.add(matrix[j][i]);
            switch (status) {
                case 0: {
                    i++;
                    if (i >= l1) {
                        status = 1;
                        l1--;
                        continue;
                    }
                    break;
                }
                case 1: {
                    j++;
                    if (i == l2) {
                        status = 2;
                        l2--;
                        continue;
                    }
                    break;
                }
                case 2: {
                    i--;
                    if (i == l3) {
                        status = 3;
                        l3++;
                        continue;
                    }
                    break;
                }
                case 3: {
                    j--;
                    if (j == l4) {
                        status = 0;
                        l4++;
                        continue;
                    }
                    break;
                }
            }
        }
        return ans;
    }
}
