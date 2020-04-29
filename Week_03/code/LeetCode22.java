import org.junit.Test;

import java.util.*;

/**
 * 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 2020/04/27
 * 2020/04/28 二刷，对StringBuilder的方法不熟悉
 * 2020/04/29 三刷
 */
public class LeetCode22 {
    @Test
    public void name() {
        System.out.println(generateParenthesis(5));
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        helper(n, n, "", ans);
        return ans;
    }

    private void helper(int left, int right, String s, List<String> ans) {
        // terminator
        if (left == 0 && right == 0) {
            ans.add(s);
            return;
        }

        // drill drop
        if (left > 0) helper(left - 1, right, s + "(", ans);
        if (right > left) helper(left, right - 1, s + ")", ans);
    }
}
