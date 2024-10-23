package leetcode.editor.en;

import java.util.*;

class RomanToInteger {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int romanToInt(String s) {
        int start = 0, out = 0;
        RomanDigit[][] ordersOfMagnitude = new RomanDigit[][]{
                RomanDigit.THOUSANDS, RomanDigit.HUNDREDS, RomanDigit.TENS, RomanDigit.ONES
        };
        for (RomanDigit[] choices : ordersOfMagnitude) {
            for (RomanDigit digit : choices) {
                if (digit.text.equals(safeSubstring(s, start, start + digit.length))) {
                    out += digit.value;
                    start += digit.length;
                    break;
                }
            }
        }
        return out;
    }
    private String safeSubstring(String s, int start, int end){
        if(end > s.length()) return null;
        return s.substring(start, end);
    }
    private record RomanDigit(
            String text,
            int length,
            int value
    ){
        final static RomanDigit[] ONES = new RomanDigit[]{
                new RomanDigit("III",  3, 3),
                new RomanDigit("II",   2, 2),
                new RomanDigit("IV",   2, 4),
                new RomanDigit("IX",   2, 9),
                new RomanDigit("VIII", 4, 8),
                new RomanDigit("VII",  3, 7),
                new RomanDigit("VI",   2, 6),
                new RomanDigit("V",    1, 5),
                new RomanDigit("I",    1, 1)
        };
        final static RomanDigit[] TENS = new RomanDigit[]{
                new RomanDigit("XXX",  3, 30),
                new RomanDigit("XX",   2, 20),
                new RomanDigit("XC",   2, 90),
                new RomanDigit("XL",   2, 40),
                new RomanDigit("LXXX", 4, 80),
                new RomanDigit("LXX",  3, 70),
                new RomanDigit("LX",   2, 60),
                new RomanDigit("L",    1, 50),
                new RomanDigit("X",    1, 10)
        };
        final static RomanDigit[] HUNDREDS = new RomanDigit[]{
                new RomanDigit("CCC",  3, 300),
                new RomanDigit("CC",   2, 200),
                new RomanDigit("CM",   2, 900),
                new RomanDigit("CD",   2, 400),
                new RomanDigit("DCCC", 4, 800),
                new RomanDigit("DCC",  3, 700),
                new RomanDigit("DC",   2, 600),
                new RomanDigit("D",    1, 500),
                new RomanDigit("C",    1, 100)
        };
        final static RomanDigit[] THOUSANDS = new RomanDigit[]{
                new RomanDigit("MMM", 3, 3000),
                new RomanDigit("MM",  2, 2000),
                new RomanDigit("M",   1, 1000)
        };

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}