import org.junit.Test;

/**
 * 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 2020/04/29
 */
public class LeetCodeInterview05 {
    @Test
    public void name() {

    }

    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                builder.append("%20");
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();

    }
}
