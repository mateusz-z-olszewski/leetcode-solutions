package leetcode.editor.en;

import java.util.*;

class ThreeSumClosest {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // O(n2 log n) solution - 2 loops through all elements and a binary search over the remaining possible values
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int sum = 0; // guaranteed to be overwritten in the loop.
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int b = nums[j];
                int closest = closestInArray(nums, j + 1, target-a-b);
                int delta = Math.abs(a + b + closest - target);
                if(delta < min){
                    min = delta;
                    sum = a + b + closest;
                }
            }
        }
        return sum;
    }


    /**
     * Returns the closest (lowest absolute difference) element in the input sorted array, whose index is at least start
     * @param nums a sorted array of integers
     * @param start start from this index
     * @param x the target value
     * @return the closest element in the array
     */
    int closestInArray(int[] nums, int start, int x){
        if(start >= nums.length) throw new RuntimeException();
        int binarySearchIndex = binarySearch0(nums, start, nums.length, x);
        if(binarySearchIndex >= 0) return x;
        int insertionPoint = -(binarySearchIndex + 1);
        if(insertionPoint == 0) return nums[0];
        if(insertionPoint == nums.length) return nums[nums.length - 1];
        int greater = nums[insertionPoint];
        if(insertionPoint <= start) return greater;
        int smaller = nums[insertionPoint - 1];
        return Math.abs(smaller - x) < Math.abs(greater - x) ? smaller : greater;
    }

    // private method copied from JDK's Arrays class.
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