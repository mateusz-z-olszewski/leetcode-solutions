package leetcode.editor.en;

import java.util.*;

class FirstMissingPositive {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        // first reorganize the array so that items in range [1, n] are at indexes one
        // lower than their value.

        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            while (1 <= v && v <= nums.length){
                int temp = nums[v - 1];
                if (temp == v) break; // is in correct place
                nums[v - 1] = v;
                v = temp;
            }
        }

        // then, see up to which element are they in their right place
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) return i + 1;
        }
        return nums.length + 1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}