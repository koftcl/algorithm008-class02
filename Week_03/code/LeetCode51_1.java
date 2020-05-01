import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * N皇后
 * https://leetcode-cn.com/problems/n-queens/
 * 2020/05/01
 */
public class LeetCode51_1 {
    @Test
    public void name() {
        for (List<String> solveNQueen : solveNQueens(8)) {
            System.out.println(solveNQueen);
        }
    }

    /**
     * 回溯
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>(n);
        HashSet<Integer> pie = new HashSet<>();
        HashSet<Integer> na = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        dfs(ans, curr, pie, na, col, n);
        return ans;
    }

    private List<String> genarator(List<Integer> curr) {
        List<String> res = new LinkedList<>();
        for (Integer i : curr) {
            StringBuilder builder = new StringBuilder();
            for (int k = 0; k < curr.size(); k++) {
                if (k == i) {
                    builder.append('Q');
                } else {
                    builder.append('.');
                }
            }
            res.add(builder.toString());
        }
        return res;
    }

    private void dfs(List<List<String>> ans, List<Integer> curr, HashSet<Integer> pie, HashSet<Integer> na, HashSet<Integer> col, int max) {
        // terminator
        if (curr.size() >= max) {
            ans.add(genarator(curr));
            return;
        }

        int j = curr.size();
        for (int i = 0; i < max; i++) {
            if (pie.contains(i + j) || na.contains(i - j) || col.contains(i)) continue;
            pie.add(i + j);
            na.add(i - j);
            col.add(i);
            curr.add(i);
            dfs(ans, curr, pie, na, col, max);
            pie.remove(i + j);
            na.remove(i - j);
            col.remove(i);
            curr.remove(curr.size() - 1);
        }
    }
}
