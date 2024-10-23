package leetcode.editor.en;

import java.util.*;

class MinimumWindowSubstring {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    final static int NOT_FOUND = Integer.MAX_VALUE;
    private static final String EMPTY_STRING = "";

    // iterate over the string s, take note of the lowest index of a char that is being searched for.
    // for example, for s=ADOBECODEBANC, t=ABC, i=7:
    // ADOBECODEBANC
    // ^  ^ ^ ^
    // 0  3 5 i
    // the difference between i and the lowest index is is the length of the minimum window that would end at index i.
    public String minWindow(String s, String t) {
        CappedQueuesManager cqm = new CappedQueuesManager(t);
        int min = NOT_FOUND;
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!cqm.getCharset().contains(c)) continue;
            boolean isFull = cqm.enqueue(c, i);
            if (isFull) {
                int lowest = cqm.getLowest();
                // vvv  meaning that there is the required number of occurences of that character in the `s` string
                if(i - lowest < min){
                    min = i - lowest;
                    prev = i;
                }
            }
        }
        if(min == NOT_FOUND) return EMPTY_STRING;
        return s.substring(prev - min, prev + 1);
    }

    /**
     * This class can store capped queues in an order, and perform basic operations.
     */
    static class CappedQueuesManager {
        Map<Character, CappedIntQueue> charQueuesMap;
        LinkedList<CappedIntQueue> sortedQueuesList;
        Set<Character> charset;
        Set<CappedIntQueue> notYetFullQueues;
        public CappedQueuesManager(String t){
            charQueuesMap = new HashMap<>();
            sortedQueuesList = new LinkedList<>();
            // count chars in the input string
            Map<Character, Integer> countInT = new HashMap<>(52); // a-zA-Z is 52 chars
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                countInT.put(c, countInT.getOrDefault(c, 0) + 1);
            }
            charset = countInT.keySet();
            // populate queues accordingly
            for (char c : charset){
                CappedIntQueue cq = new CappedIntQueue(countInT.get(c), -1);
                charQueuesMap.put(c, cq);
                sortedQueuesList.add(cq);
            }
            notYetFullQueues = new HashSet<>(sortedQueuesList);
        }
        public Set<Character> getCharset(){
            return charset;
        }
        /**
         * Get the lowest item in the whole data structure
         */
        public int getLowest(){
            return sortedQueuesList.getFirst().getFirst();
        }
        /**
         * Add an item for char c, update the position of the appropriate queue in the structure
         * @return was every character in input string seen already (enqueued at least as many times as it appears)
         */
        public boolean enqueue(char c, int i){
            CappedIntQueue queue = charQueuesMap.get(c);
            sortedQueuesList.remove(queue);
            boolean isFull = queue.enqueue(i);
            putInSortedList(queue);
            if(isFull && !notYetFullQueues.isEmpty()) notYetFullQueues.remove(queue);
            return notYetFullQueues.isEmpty();
        }
        private void putInSortedList(CappedIntQueue queue){
            int first = queue.getFirst();
            ListIterator<CappedIntQueue> iterator = sortedQueuesList.listIterator();
            while(true){
                if(!iterator.hasNext()){
                    iterator.add(queue);
                    break;
                }
                var q = iterator.next();
                if(q.getFirst() > first){
                    iterator.previous();
                    iterator.add(queue);
                    break;
                }
            }
        }
    }

    static class CappedIntQueue {
        private final Deque<Integer> queue;
        private final int capacity;
        private final int defaultValue;
        public CappedIntQueue(int capacity, int defaultValue){
            this.capacity = capacity;
            this.queue = new ArrayDeque<>(capacity + 1);
            this.defaultValue = defaultValue;
        }
        /**
         * Enqueue the given item. Return true is the queue is full after this operation.
         * Remove that item if the queue exceeded its capacity.
         */
        public boolean enqueue(int i) {
            queue.add(i);
            boolean out = queue.size() >= capacity;
            if(queue.size() > capacity) queue.removeFirst();
            return out;
        }
        public int getFirst(){
            return queue.isEmpty() ? defaultValue : queue.getFirst();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}