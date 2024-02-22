package leetcode.editor.en;

import java.util.*;

class ZigzagConversion {

//leetcode submit region begin(Prohibit modification and deletion)
class Chooser implements Iterator<Integer> {
    int size;
    int current = 0;
    int d = 1;

    public Chooser(int size) {
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        int out = current;
        current += d;

        if(current == size - 1 || current == 0) d *= -1;
        return out;
    }
}
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < builders.length; i++) builders[i] = new StringBuilder();
        Chooser ch = new Chooser(numRows);

        for (int i = 0; i < s.length(); i++) {
            builders[ch.next()].append(s.charAt(i));
        }
        StringBuilder out = new StringBuilder();

        for (var sb : builders) out.append(sb);
        return out.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}