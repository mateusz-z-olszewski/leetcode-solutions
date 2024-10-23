package leetcode.editor.en;

class PlusOne {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = 0;
        for (; i < len; i++) { // check if input is only 9s
            if(digits[i] != 9) break;
        }
        if(i == len){ // if input was all 9s so the result is 1 and 0s
            var out = new int[len + 1];
            out[0] = 1;
            return out;
        }

        int carry = 1; // because the number we are adding is just 1, we can simply start with that value as carry
        for (int j = len - 1; j >= 0; j--) {
            int sum = digits[j] + carry;
            if(sum == 10){
                carry = 1;
                sum = 0;
            } else {
                carry = 0;
            }
            digits[j] = sum;
        }
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}