package leetcode.editor.en;

import java.util.*;

class FourSum {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> out = new HashSet<>();
        Set<Long> seen = new HashSet<>();
        Arrays.sort(nums);
        long t = target;
        for (int i = 0; i < nums.length; i++) {
            long a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                long b = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    long c = nums[k];
                    if(seen.contains(target-a-b-c)) out.add(List.of(
                            (int) (t - a - b - c),
                            (int) a,
                            (int) b,
                            (int) c
                    ));
                }
            }
            seen.add(a);
        }
        return out.stream().toList();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}