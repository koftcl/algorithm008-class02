package prepare;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 字符串相加
 * https://leetcode-cn.com/problems/add-strings/
 * 2020/04/28
 */
public class LeetCode415 {
    @Test
    public void name() {
        System.out.println(addStrings("12121", "21212"));
    }

    /**
     * 从低位开始逐个向高位处理
     * 学到了StringBuilder 的reverse方法
     */
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int i = len1 - 1, j = len2 - 1;
        int add = 0;
        while (i >= 0 || j >= 0) {
            int tmp = add;
            add = 0;
            if (i >= 0) tmp += num1.charAt(i) - '0';
            if (j >= 0) tmp += num2.charAt(j) - '0';
            add += tmp / 10;
            builder.append(tmp % 10);
            i--;
            j--;
        }
        if (add > 0) {
            builder.append(add);
        }
        return builder.reverse().toString();
    }
}
