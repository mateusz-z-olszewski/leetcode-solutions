package leetcode.editor.en;

import java.util.*;

class SwapNodesInPairs {

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
// using solution for 25
class Solution {
    public ListNode swapPairs(ListNode head) {
        return reverseKGroup(head, 2);
    }

    ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(0, head);
        ListNode lastInGroup = reverseKNodes(pre, k);
        if(lastInGroup == null) return head;
        while(lastInGroup != null)lastInGroup = reverseKNodes(lastInGroup, k);
        return pre.next;
    }

    /**
     * Reverses k nodes, then returns the last node of the reversed group, being
     * the head node before reversing. If there is less than k nodes in the linked list
     * (from and including the head), does not reverse anything and returns null.
     * @param prehead A node which points to the head
     * @param k how many nodes to reverse
     * @return prehead.next, being the last node of the reversed group
     */
    ListNode reverseKNodes(ListNode prehead, int k){
        ListNode last = prehead;
        for (int i = 0; i < k; i++) {
            if(last.next == null) return null;
            last = last.next;
        }
        ListNode out = prehead.next;
        ListNode prev = last.next, current = prehead.next;
        for (int i = 0; i < k; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        prehead.next = prev;
        return out;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
}