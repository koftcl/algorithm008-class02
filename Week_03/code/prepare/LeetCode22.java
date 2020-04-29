package prepare;

import org.junit.Test;

import java.util.*;

/**
 * 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 2020/04/27
 * 2020/04/28 二刷，对StringBuilder的方法不熟悉
 */
public class LeetCode22 {
    @Test
    public void name() {
        System.out.println(generateParenthesis(5));
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        backTrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    /**
     * 回溯法
     */
    public void backTrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return; // 不加return 会导致死循环
        }

        if (open < max) {
            cur.append('(');
            backTrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (close < open) {
            cur.append(')');
            backTrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
