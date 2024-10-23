package leetcode.editor.en;

class PalindromeNumber {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x <= 9) return true;

        int log = intLog10(x);
        int high = intPow(10, log);
        for (int i = 0; i < (log + 1) / 2; i++) {
            if(x / high != x % 10) return false;
            x = (x % high) / 10; // strip away first and last digit
            high /= 100;
        }
        return true;
    }

    /**
     * Logarithm base 10 of x, rounded down
     * @param x a positive number
     */
    private int intLog10(int x){
        int out = 0;
        while(x > 9){
            out++;
            x /= 10;
        }
        return out;
    }
    private int intPow(int base, int exponent){
        int out = 1;
        for (int i = 0; i < exponent; i++) out *= base;
        return out;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}