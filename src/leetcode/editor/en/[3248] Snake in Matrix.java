package leetcode.editor.en;

import java.util.*;

class SnakeInMatrix {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int pos = 0;
        for(String command : commands){
            switch(command){
                case "LEFT" -> pos -= 1;
                case "RIGHT" -> pos += 1;
                case "UP" -> pos -= n;
                case "DOWN" -> pos += n;
            }
        }
        return pos;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}