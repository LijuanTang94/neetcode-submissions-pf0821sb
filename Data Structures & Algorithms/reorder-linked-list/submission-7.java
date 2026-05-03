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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondhalf = slow.next;
        ListNode r = reverse(secondhalf);
        slow.next = null;
        ListNode l = head;
        while (r != null) {
            ListNode lnext = l.next;
            ListNode rnext = r.next;
            l.next = r;
            r.next = lnext;
            l = lnext;
            r = rnext;
        }
    }
    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode nxt = node.next;
            node.next = pre;
            pre = node;
            node = nxt;
        }
        return pre;
    }
}
