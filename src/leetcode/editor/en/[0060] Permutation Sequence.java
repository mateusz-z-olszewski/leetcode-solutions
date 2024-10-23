package leetcode.editor.en;

import java.util.*;

class PermutationSequence {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getPermutation(int n, int k) {
        k -= 1; // because our algorithm 0-indexes permutations
        StringBuilder sb = new StringBuilder();

        List<Character> chars = new ArrayList<>(9);
        for (int i = 0; i < n; i++) chars.add((char) ('1' + i)); // populate the array with n first digits in order

        int magnitude = factorial(n - 1);
        for (int i = n - 1; i > 0; i--) {
            char c = chars.remove(k / magnitude);
            k %= magnitude;
            magnitude /= i; // could also be magnitude = factorial(i - 1);
            sb.append(c);
        }
        sb.append(chars.getFirst()); // there should remain just one character in the list
        return sb.toString();
    }

    // could be easily upgraded for larger n.
    public int factorial(int n){
        return FACTORIALS[n];
    }
    private final int[] FACTORIALS = new int[]{
            1,
            1,
            2,
            6,
            24,
            120,
            720,
            5040,
            40320,
            362880
    };

}
//leetcode submit region end(Prohibit modification and deletion)


}