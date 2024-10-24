package leetcode.editor.en;

class DivideTwoIntegers {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int divide(int dividend, int divisor) {
        int out = 0;
        boolean isNegative = dividend < 0 ^ divisor < 0;
        int remainingAbsDividend, absDivisor = abs(divisor);
        // special cases for INT_MIN:
        if(dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) return 1;
        if(divisor == Integer.MIN_VALUE) return 0; // nothing has absolute value greater than INT_MIN, so its 0
        if(dividend == Integer.MIN_VALUE){
            // only possibility for a result outside of integer range.
            if(divisor == -1) return Integer.MAX_VALUE;
            int shift = 1 + largestLesserEqLeftShift(1 << 30, absDivisor);
            out = 1 << shift;
            int subtract = absDivisor << shift;
            remainingAbsDividend = dividend - subtract; // always positive
        } else {
            remainingAbsDividend = abs(dividend);
        }
        // normal cases
        if(remainingAbsDividend < absDivisor) return isNegative ? neg(out) : out;
        while(remainingAbsDividend >= absDivisor){
            int lShift = largestLesserEqLeftShift(remainingAbsDividend, absDivisor);
            remainingAbsDividend -= absDivisor << lShift;
            out |= 1 << lShift;
        }
        return isNegative? neg(out) : out;
    }

    /**
     * Returns by how many bits can toShift be shifted left to still be lesser or equal to limit.
     * E.g. for limit=10010, toShift=101, result is 1 because 101<<1=1010, which is smaller than 10010.
     * @param limit positive integer
     * @param toShift positive integer
     * @return
     */
    int largestLesserEqLeftShift(int limit, int toShift){
        int i = 0;
        while(limit >= toShift && toShift > 0) {
            toShift <<= 1;
            i++;
        }
        return i - 1;
    }
    int abs(int x){
        return x >= 0 ? x : neg(x);
    }
    int neg(int x) {
        return ~x + 1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}