package leetcode.editor.en;

import java.util.*;

class RemoveElement {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;

        while(true){
            while(right > 0 && nums[right] == val) right--;
            while(left < nums.length && nums[left] != val) left++;
            if(left >= right) return left;
            swap(nums, left, right);
        }
    }

    void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}