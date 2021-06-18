package LeetCodeTwoSum;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeTwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mappaInteri = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement =  target - nums[i];
            if(mappaInteri.containsKey(complement)){
                return new int[] {mappaInteri.get(complement),i};
            }
            mappaInteri.put(nums[i],i);
        }
        return null;
    }
}
