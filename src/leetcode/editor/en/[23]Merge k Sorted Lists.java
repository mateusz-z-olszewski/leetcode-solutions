package leetcode.editor.en;

import java.util.*;

class MergeKSortedLists {

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> input = new ArrayList<>(Arrays.asList(lists));
        input.removeIf(Objects::isNull);
        if(input.isEmpty()) return null;
        Comparator<ListNode> comparator = Comparator.comparingInt(l -> l.val);
        PriorityQueue<ListNode> pq = new PriorityQueue<>(input.size(), comparator);
        pq.addAll(input);

        ListNode preOut = new ListNode();
        ListNode current = preOut;

        while(!pq.isEmpty()){
            ListNode l = pq.remove();
            current = current.next = new ListNode(l.val);
            if(l.next != null) pq.add(l.next);
        }

        return preOut.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}