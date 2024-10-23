package leetcode.editor.en;

import java.util.*;

class RegularExpressionMatching {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        PatternMatcher pm = new PatternMatcher(s, p);

        return pm.isMatch();
    }

    static class PatternMatcher {
        private final String string;
        private final int stringLen;
        private final List<Token> tokens = new ArrayList<>();
        private final int tokensLen;
        private final Stack<State> states = new Stack<>();


        public PatternMatcher(String s, String p){
            this.string = s;
            stringLen = string.length();

            // parse the tokens from the pattern
            int i = 0;
            for (; i < p.length() - 1; i++) {
                char c = p.charAt(i);
                boolean multiple = p.charAt(i+1) == '*';
                tokens.add(new Token(c, multiple));
                if(multiple) i++;
            }
            if(i == p.length() - 1) tokens.add(new Token(p.charAt(i), false));

            tokensLen = tokens.size();
        }

        public boolean isMatch() {
            states.push(State.INITIAL_STATE);

            while(!states.empty()){
                State s = states.pop();
                // if there is a state that exhausts all characters in the string using all tokens, the pattern matches
                if(s.tokenIndex == tokensLen)
                    if(s.stringIndex == stringLen) return true;
                    else continue;
                // if(s.stringIndex == stringLen && s.tokenIndex == tokensLen) return true;
                Token t = tokens.get(s.tokenIndex);
                t.match(s);
            }

            return false;
        }

        class Token {
            private final char c;
            private final boolean multiple;

            public Token(char c, boolean multiple) {
                this.c = c;
                this.multiple = multiple;
            }

            void match(State state){
                if(multiple){
                    int i = 0;
                    do {
                        enqueueIfValid(state.stringIndex + i, state.tokenIndex + 1);
                        i++;
                    } while (matchesNext(state.stringIndex+ i - 1));
                } else {
                    if(matchesNext(state.stringIndex))
                        enqueueIfValid(state.stringIndex + 1, state.tokenIndex + 1);
                }
            }

            void enqueueIfValid(int stringIndex, int tokenIndex){
                if(stringIndex <= stringLen && tokenIndex <= tokensLen)
                    states.push(new State(stringIndex, tokenIndex));
            }

            boolean matchesNext(int sIndex) {
                if(sIndex >= string.length()) return false;
                return c == '.' || c == string.charAt(sIndex);
            }

        }

        /**
         * Represents a state the pattern matcher can be in, for example (3, 5) means that it will now evaluate the 3rd
         * token against the string starting from its 5th character inclusive.
         */
        record State(
                int stringIndex,
                int tokenIndex
        ){
            static State INITIAL_STATE = new State(0, 0);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)


}
