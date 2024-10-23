package leetcode.editor.en;

import java.util.*;

class MedianOfTwoSortedArrays {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    record Pair(int i1, int i2){}
    private static final int CUTOFF = 10;
    class Subarray {
        final int[] array;
        int start, end; // start is inclusive, end is exclusive.

        public Subarray(int[] array) {
            this.array = array;
            start = 0;
            end = array.length;
        }


        public void trimLeft(int t){
            start += t;
        }
        public void trimRight(int t){
            end -= t;
        }

        /**
         * Trims an equal number of numbers from the beginning and end.
         * @param trimsize should be nonnegative, smaller than array.length/2-1
         */
        public void trimBorders(int trimsize) {
            start += trimsize;
            end -= trimsize;
        }

        public int size(){
            return end - start;
        }


        /**
         * Returns a pair of the n-th element from the left and right
         * of the subarray.
         * @param n
         */
        public Pair midnumbers(int n){
            return new Pair(array[start + n - 1], array[end - n]);
        }
    }
    private Subarray a, b; // a.size() >= b.size()

    /**
     * Solves the task in O(log(m)+log(n)) = O(log(mn) time complexity
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        a = new Subarray(nums1);
        b = new Subarray(nums2);
        restore();
        normalize();

        while(a.size() + b.size() > CUTOFF){
            split();
            restore();
            normalize();
        }

        return bruteforce();
    }

    private void swap(){
        var t = a;
        a = b;
        b = t;
    }
    private void normalize(){
        int diff = a.size() - b.size();
        int trimsize = diff/2 - 1;
        if(trimsize > 0) {
            a.trimBorders(trimsize);
            restore();
        }
    }
    private void restore(){
        if(a.size() < b.size()) swap();
    }
    private void split(){
        // halve both array and discard the halves which are guaranteed not
        // to contain the median
        // aaaaaaaaL ----  Haaaaaaaa
        // bbbbbbbbH  -   Lbbbbbbbb
        // we distard the lower of the two lower halves, and higher of the
        // two upper halves
        int trimsize = b.size() / 2;
        var mida = a.midnumbers(trimsize);
        var midb = b.midnumbers(trimsize);

        (mida.i1 < midb.i1 ? a : b).trimLeft(trimsize);
        (mida.i2 > midb.i2 ? a : b).trimRight(trimsize);

    }
    private double bruteforce(){
        int size = a.size() + b.size();
        int[] array = new int[size];
        System.arraycopy(a.array, a.start, array, 0, a.size());
        System.arraycopy(b.array, b.start, array, a.size(), b.size());
        Arrays.sort(array);
        int halfsize = array.length/2;
        if(array.length % 2 == 1) return array[halfsize];
        else return (array[halfsize - 1] + array[halfsize]) / 2.0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}