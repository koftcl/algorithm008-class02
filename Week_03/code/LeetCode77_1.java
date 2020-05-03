import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 * https://leetcode-cn.com/problems/combinations/
 * 2020/05/02
 */
public class LeetCode77_1 {
    @Test
    public void name() {
        List<List<Integer>> ans = combine(4, 2);
        for (List<Integer> an : ans) {
            System.out.println(an);
        }
    }

    /**
     * 回溯
     */
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (n == 0 || k == 0) return ans;

        LinkedList<Integer> curr = new LinkedList<>();
        backTrack(ans, curr, 1, n, k);

        return ans;
    }

    private void backTrack(LinkedList<List<Integer>> ans, LinkedList<Integer> curr, int i, int n, int k) {
        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (; i <= n; i++) {
            curr.add(i);
            backTrack(ans, curr, i + 1, n, k);
            curr.pollLast();
        }
    }
}
