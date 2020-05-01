import org.junit.Test;

import java.util.*;

/**
 * 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 2020/05/01
 */
public class LeetCode17 {
    @Test
    public void name() {
        System.out.println(letterCombinations("23"));
    }

    Map<Character, char[]> map = new HashMap<>();

    /**
     * 分治
     */
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        map.put('2', new char[]{'a', 'b','c'});
        map.put('3', new char[]{'d', 'e','f'});
        map.put('4', new char[]{'g', 'h','i'});
        map.put('5', new char[]{'j', 'k','l'});
        map.put('6', new char[]{'m', 'n','o'});
        map.put('7', new char[]{'p', 'q','r', 's'});
        map.put('8', new char[]{'t','u', 'v'});
        map.put('9', new char[]{'w', 'x','y', 'z'});

        helper(ans, digits, 0, "");
        return ans;
    }

    private void helper(List<String> ans, String digits, int i, String curr) {
        if (digits.length() == i) {
            ans.add(curr);
            return;
        }

        for (char ch : map.get(digits.charAt(i))) {
            helper(ans, digits, i + 1, curr + ch);
        }

    }

    /**
     * 迭代
     */
    public List<String> letterCombinations1(String digits) {
        ArrayList<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        map.put('2', new char[]{'a', 'b','c'});
        map.put('3', new char[]{'d', 'e','f'});
        map.put('4', new char[]{'g', 'h','i'});
        map.put('5', new char[]{'j', 'k','l'});
        map.put('6', new char[]{'m', 'n','o'});
        map.put('7', new char[]{'p', 'q','r', 's'});
        map.put('8', new char[]{'t','u', 'v'});
        map.put('9', new char[]{'w', 'x','y', 'z'});

        ans.add("");
        for (char in : digits.toCharArray()) {
            ArrayList<String> curr = new ArrayList<>();
            for (String s : ans) {
                for (char ch : map.get(in)) {
                    curr.add(s + ch);
                }
            }
            ans = curr;
        }
        return ans;
    }
}
