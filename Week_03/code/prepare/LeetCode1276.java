package prepare;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 不浪费原料的汉堡制作方案
 * https://leetcode-cn.com/problems/number-of-burgers-with-no-waste-of-ingredients/
 * 2020/04/28
 */
public class LeetCode1276 {
    @Test
    public void name() {

    }

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (tomatoSlices % 2 == 1) {
            return ans;
        }
        if (tomatoSlices > 4 * cheeseSlices) {
            return ans;
        }
        if (tomatoSlices < 2 * cheeseSlices) {
            return ans;
        }
        int tmp = cheeseSlices * 4 - tomatoSlices;
        tmp /= 2;
        ans.add(tmp);
        ans.add(cheeseSlices - tmp);
        return ans;
    }
}
