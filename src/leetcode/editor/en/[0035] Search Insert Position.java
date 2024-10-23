package leetcode.editor.en;

class SearchInsertPosition {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        return searchRecursive(nums, 0, nums.length, target);
    }

    final int LINEAR_CUTOFF = 4;
    private int searchRecursive(int[] nums, int low, int high, int target){
        if(high - low <= LINEAR_CUTOFF){
            for (int i = low; i < high; i++)
                if (target <= nums[i]) return i;
            return high;
        }

        int midpoint = (high + low) / 2;
        if(target < nums[midpoint]) return searchRecursive(nums, low, midpoint, target);
        else return searchRecursive(nums, midpoint, high, target);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}