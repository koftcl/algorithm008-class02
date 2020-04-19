import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode20 {
    @Test
    public void name() {
        System.out.println(isValid("()"));
    }
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty()) return false;
            if (map.get(stack.pop()) != ch) return false;
        }

        return stack.isEmpty();
    }
}
