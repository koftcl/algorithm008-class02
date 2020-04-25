import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 * 删除最外层的括号
 * 2020/04/22
 */
public class LeetCode1021 {
    @Test
    public void name() {
        System.out.println(removeOuterParentheses(
                "(()())(())"));
    }

    public String removeOuterParentheses(String S) {
        int flag = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                flag++;
                if (flag == 1) {
                    continue;
                }
            } else if (ch == ')') {
                flag--;
            }

            if (flag > 0) {
                builder.append(ch);
            }
        }
        return builder.toString();
    }
}
