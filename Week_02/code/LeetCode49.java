import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class LeetCode49 {
    @Test
    public void name() {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        for (List<String> group : groupAnagrams(strs)) {
            for (String s : group) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用HashMap
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        LinkedList<List<String>> ans = new LinkedList<>();
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = Arrays.toString(charArr);
            List<String> list = map.getOrDefault(key, new LinkedList<>());
            list.add(str);
            map.put(key, list);
        }

        for (List<String> value : map.values()) {
            ans.add(value);
        }
        return ans;

    }
}
