package leetcode.editor.en;

import java.util.*;

class IntegerToRoman {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public final String[] THOUSANDS = {"", "M", "MM", "MMM"};
    public final String[] HUNDREDS =  {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    public final String[] TENS =      {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    public final String[] ONES =      {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(THOUSANDS[num / 1000]);
        num %= 1000;
        sb.append(HUNDREDS[num / 100]);
        num %= 100;
        sb.append(TENS[num / 10]);
        num %= 10;
        sb.append(ONES[num]);
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}