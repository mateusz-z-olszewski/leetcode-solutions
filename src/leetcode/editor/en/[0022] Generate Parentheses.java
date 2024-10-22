package leetcode.editor.en;

import java.util.*;

class GenerateParentheses {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    final boolean OPEN = true;
    final boolean CLOSE = false;
    public List<String> generateParenthesis(int n) {
        Deque<Boolean> operations = new ArrayDeque<>();
        List<String> out = new ArrayList<>();
        evaluate(operations, out, 0, n);
        return out;
    }
    public void evaluate(Deque<Boolean> operations, List<String> possibilities, int opened, int toOpen){
        if(opened == 0 && toOpen == 0){
            possibilities.add(operationsToParenthesis(operations));
            return;
        }
        if(toOpen > 0){
            operations.push(OPEN);
            evaluate(operations, possibilities, opened + 1, toOpen - 1);
            operations.pop();
        }
        if(opened > 0){
            operations.push(CLOSE);
            evaluate(operations, possibilities, opened - 1, toOpen);
            operations.pop();
        }
    }

    private String operationsToParenthesis(Deque<Boolean> operations){
        StringBuilder sb = new StringBuilder();
        Boolean[] array = new Boolean[operations.size()];
        operations.toArray(array);
        for (Boolean b : array) sb.append(b ? ')' : '(');
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}