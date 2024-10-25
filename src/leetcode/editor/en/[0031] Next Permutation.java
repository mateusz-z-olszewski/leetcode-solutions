package leetcode.editor.en;

import java.util.*;

class NextPermutation {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1) return;
        int last = -1; // guaranteed to be smaller than any value in nums
        int i = nums.length - 1;
        for(; i >= 0; i--) {
            if(nums[i] >= last) last = nums[i];
            else break; // i is the index of the first item from the end to be smaller than item with index i+1
        }
        if(i == -1){ // array is descending. simply fully reverse it
            reverse(nums, 0);
            return;
        }
        reverse(nums, i + 1);
        swapWithNextHighest(nums, i);
    }

    private void swapWithNextHighest(int[] nums, int i) {
        int valueToReplace = nums[i];
        int swapIndex = binarySearch0(nums, i + 1, nums.length, valueToReplace);
        if(swapIndex < 0) {
            swap(nums, i, -swapIndex - 1);
            return;
        }
        while(valueToReplace == nums[swapIndex]) swapIndex++; // in the case there are multiple occurences
        swap(nums, i, swapIndex);
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Reverse array elements starting from low (inclusive).
     */
    void reverse(int[] nums, int low){
        int high = nums.length;
        while(low < high) swap(nums, low++, --high);
    }

    // private method copied from JDK's Arrays class.
    // This really should be public! I'm copying it for the 2nd time already
    private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while(low <= high) {
            int mid = low + high >>> 1;
            int midVal = a[mid];
            if (midVal < key) {
                low = mid + 1;
            } else {
                if (midVal <= key) {
                    return mid;
                }

                high = mid - 1;
            }
        }

        return -(low + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}