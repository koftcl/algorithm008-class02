package prepare;

import org.junit.Test;

import java.util.HashMap;

/**
 * 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class LeetCode242 {
    @Test
    public void name() {
        System.out.println(this.isAnagram("anagram", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (charMap.containsKey(ch)) {
                if (charMap.get(ch) == 1) {
                    charMap.remove(ch);
                } else {
                    charMap.put(ch, charMap.get(ch)-1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
