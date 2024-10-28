package leetcode.editor.en;

class FindFirstAndLastPositionOfElementInSortedArray {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = universalBinarySearch(0, nums.length, (i) -> {
            if(nums[i] == target && (i == 0 || nums[i - 1] < target)) return 0;
            if(nums[i] < target) return 1;
            else return -1;
        });
        int end = universalBinarySearch(0, nums.length, (i) -> {
            if(nums[i] == target && (i + 1 == nums.length || nums[i + 1] > target)) return 0;
            if(nums[i] > target) return -1;
            else return 1;
        });
        return new int[]{start, end};
    }


    /**
     * Returns the value {@code low <= i < high} for which {@code cmp(i) == 0}, assuming that
     * for all {@code j > i}, {@code cmp(j) < 0} and for all {@code j < i}, {@code cmp(j) > 0}.
     * @param low lower bound of i (inclusive)
     * @param high upper bound of i (exclusive)
     * @param cmp function of an integer that returns a valid integer as described above for all
     * {@code low <= i < high}
     * @return appropriate value of {@code i} such that {@code cmp(i) == 0}. If there are more than one such values,
     * may return any of them.
     */
    int universalBinarySearch(int low, int high, IntComparator cmp){
        while(low < high){
            int midpoint = low + high >> 1;
            int result = cmp.compare(midpoint);
            if(result == 0) return midpoint;
            if(result < 0){
                high = midpoint;
            } else {
                low = midpoint + 1;
            }
        }
        return -1;
    }

    @FunctionalInterface
    interface IntComparator {
        /**
         * Determines if the desired value is the given one (zero), a smaller one (negative value) or a greater
         * one (positive value).
         */
        int compare(int index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}