package leetcode.editor.en;

import java.util.*;

class ReverseInteger {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        int negMask = Integer.MIN_VALUE & x;
        int maxAllowedBeforeMultiplication = Integer.MAX_VALUE / 10;
        int out = 0;
        while(x != 0){
            if(Math.abs(out) > maxAllowedBeforeMultiplication) return 0;
            out = out * 10 + x % 10;
            x /= 10;
        }
        return out | negMask;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}