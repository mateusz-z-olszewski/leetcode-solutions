package leetcode.editor.en;

import java.util.*;

class SearchInRotatedSortedArray {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int x) {
        int low = 0, high = nums.length;
        while(low < high){
            int midpoint = (low + high) / 2, m = nums[midpoint];
            if(x == m) return midpoint;
            int l = nums[low], h = nums[high - 1];
            boolean searchLeftNext;
            if(l < h){ // simple binary search
                searchLeftNext = x < m;
            } else if(l < m){ // pivot is to the right of the midpoint, so interval l--m is increasing
                searchLeftNext = l <= x && x < m;
            } else { // pivot is to the left of the midpoint, so interval m--h is increasing
                searchLeftNext = !(m < x && x <= h);
            }
            if(searchLeftNext) high = midpoint;
            else low = midpoint + 1;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}