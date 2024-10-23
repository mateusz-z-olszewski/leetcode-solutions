package leetcode.editor.en;

import java.util.*;

class ThreeSum {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> out = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if(seen.contains(-a-b)) out.add(List.of(-a-b, a, b));
            }
            seen.add(a);
        }
        return out.stream().toList();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}