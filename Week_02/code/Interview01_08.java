import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 面试题 01.08. 零矩阵
 * https://leetcode-cn.com/problems/zero-matrix-lcci/
 */
public class Interview01_08 {
    @Test
    public void name() {
        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{0,1,2,0};
    }

    /**
     * 遍历矩阵，存放为0的行列，设置成0
     */
    public void setZeroes(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();

        // 扫描矩阵
        for (int i = 0; i < colSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                if (matrix[j][i] == 0) {
                    // 存放需要删除的行和列号，需去重
                    col.add(i);
                    row.add(j);
                }
            }
        }

        // 遍历需要设置零的行号、列号并设置为零
        for (Integer j : row) {
            for (int i = 0; i < colSize; i++) {
                matrix[j][i] = 0;
            }
        }

        for (Integer i : col) {
            for (int j = 0; j < rowSize; j++) {
                matrix[j][i] = 0;
            }
        }
    }
}
