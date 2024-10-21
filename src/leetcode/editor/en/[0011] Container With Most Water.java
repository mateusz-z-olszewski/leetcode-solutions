package leetcode.editor.en;

import java.util.*;

class ContainerWithMostWater {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // O(k^2) implementation where k is the count of crucial lines (lines which have no lower lines in some direction).
    public int maxArea(int[] height) {
        List<Integer> leftCrucials = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if(height[i] > max){
                max = height[i];
                leftCrucials.add(i);
            }
        }
        List<Integer> rightCrucials = new ArrayList<>();
        max = 0;
        for (int i = height.length - 1; i >= leftCrucials.getLast(); i--) {
            if(height[i] > max){
                max = height[i];
                rightCrucials.add(i);
            }
        }
        int highestArea = 0;
        for (int left : leftCrucials) {
            for (int right : rightCrucials) {
                int area = (right - left) * Math.min(height[left], height[right]);
                highestArea = Math.max(highestArea, area);
            }
        }
        return highestArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}