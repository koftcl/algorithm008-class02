import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int anotherNum = target - num;
            Integer j = numMap.get(anotherNum);
            if(j != null){
                return new int[]{i, j};
            }
            numMap.put(num, i);
        }
        return null;
    }
}
