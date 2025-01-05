package leetcode.editor.en;

import java.util.*;

class ConcatenationOfArray {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] out = new int[2 * n];
        System.arraycopy(nums, 0, out, 0, n);
        System.arraycopy(nums, 0, out, n, n);
        return out;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}