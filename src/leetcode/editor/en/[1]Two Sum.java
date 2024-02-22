package leetcode.editor.en;

import java.util.*;

class TwoSum {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seenAtIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if(seenAtIndex.containsKey(remainder))
                return new int[]{seenAtIndex.get(remainder), i};
            seenAtIndex.put(nums[i], i);
        }
        throw new RuntimeException(); // never gets here.
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}