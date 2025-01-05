package leetcode.editor.en;

import java.util.*;

class MaximumSubarray {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int tempSum = 0, out = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            tempSum += nums[i];
            if (out < tempSum) out = tempSum;
            if (tempSum < 0) tempSum = 0;
        }
        return out;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}