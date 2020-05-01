import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * N皇后
 * https://leetcode-cn.com/problems/n-queens/
 * 2020/05/01
 */
public class LeetCode51 {
    @Test
    public void name() {
        for (List<String> solveNQueen : solveNQueens(4)) {
            System.out.println(solveNQueen);
        }
    }

    /**
     * 回溯
     */
    public List<List<String>> solveNQueens(int n) {
        LinkedList<List<String>> ans = new LinkedList<>();
        if (n < 1) return ans;

        char[][] curr = new char[n][n];
        // 初始化
        init(n, curr);

        // 递归
        helper(ans, curr, n, 0);

        return ans;
    }

    private void init(int n, char[][] curr) {
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            curr[i] = chars;
        }
    }

    private void helper(List<List<String>> ans, char[][] curr, int max, int j) {
        // terminator
        if (j == max) {
            List<String> res = new LinkedList<>();
            for (char[] chars : curr) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < max; i++) {
                    if (chars[i] == 0) builder.append('.');
                    else builder.append(chars[i]);
                }
                res.add(builder.toString());
            }
            ans.add(res);
            return;
        }

        // process
        int i = 0;
        for (; i < max; i++) {
            if (curr[j][i] == 0) {
                curr[j][i] = 'Q';
                break;
            }
        }

        if (i == max) return;

        if (i < max - 1) {
            char[][] copy = copy(curr);
            copy[j][i] = '.';
            helper(ans, copy, max, j );
        }

        int add = 1;
        for (; j + add < max; add++) {
            if (i < max) curr[j + add][i] = '.';
            if (i - add >= 0) curr[j + add][i - add] = '.';
            if (i + add < max) curr[j + add][i + add] = '.';
        }

        if (j < max) helper(ans, copy(curr), max, j + 1);
    }

    private char[][] copy(char[][] curr) {
        int len = curr.length;
        char[][] newArr = new char[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < len; i++) {
                newArr[j][i] = curr[j][i];
            }
        }
        return newArr;
    }
}
