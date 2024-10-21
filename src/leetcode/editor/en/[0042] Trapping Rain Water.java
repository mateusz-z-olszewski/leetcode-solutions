package leetcode.editor.en;

import java.util.*;

class TrappingRainWater {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int maxIndex = 0, max = height[0];
        int total = 0, temptotal = 0;
        // iterate from the left to the highest point
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            if(h <= max){
                temptotal += max - h;
            } else {
                maxIndex = i;
                max = h;
                // flush the temporary counter (used to not add water after the highest point)
                total += temptotal;
                temptotal = 0;
            }
        }
        // iterate from the right to the highest point (whose index is now known)
        max = height[height.length - 1];
        for (int i = height.length - 1; i > maxIndex; i--) {
            int h = height[i];
            if(h <= max) total += max - h;
            else max = h;
        }

        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}