package leetcode.editor.en;

import java.util.*;

class RemoveNthNodeFromEndOfList {

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        for (int i = 0; i < n; i++) current = current.next;
        if(current == null) return head.next;
        ListNode trailing = head;
        while(current.next != null){
            current = current.next;
            trailing = trailing.next;
        }
        trailing.next = trailing.next.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

}