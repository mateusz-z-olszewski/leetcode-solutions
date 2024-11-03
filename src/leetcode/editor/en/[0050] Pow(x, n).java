package leetcode.editor.en;

import java.util.*;

class PowxN {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        if(x == 0.0) return 0.0;
        if(x == 1.0 || n == 0) return 1.0;
        if(x == -1.0) return n % 2 == 0 ? 1.0 : -1.0;
        if(n == Integer.MIN_VALUE) return 0;

        if (n < 0) x = 1.0 / x;
        n = Math.abs(n);
        int b = highestSetBitAsMask(n);
        double out = 1.0;
        while(b > 1) {
            if((b & n) != 0) out *= x;
            out *= out;
            b >>= 1;
        }
        if(n % 2 != 0) out *= x;
        return out;
    }

    // from https://stackoverflow.com/questions/21413565, slightly adjusted
    private int highestSetBitAsMask(int n) {
        n = n | n >> 1;
        n = n | n >> 2;
        n = n | n >> 4;
        n = n | n >> 8;
        n = n | n >> 16;
        n = (n >> 1) + 1;
        return n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}