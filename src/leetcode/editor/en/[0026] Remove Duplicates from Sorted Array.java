package leetcode.editor.en;

import java.util.*;

import static java.util.Collections.swap;

class RemoveDuplicatesFromSortedArray {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0; // insert index
        int last = -200; // lower than all elements of the array.
        for (int j = 0; j < nums.length; j++) {
            int n = nums[j];
            if(last < n){
                swap(nums, i, j);
                i++;
                last = n;
            }
        }
        return i;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}