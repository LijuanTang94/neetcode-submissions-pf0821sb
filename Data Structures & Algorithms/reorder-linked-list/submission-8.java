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
        if (head == null || head.next == null) return;
        ListNode mid = getMid(head);
        ListNode nxt = mid.next;
        mid.next = null;
        ListNode r = reverse(nxt);
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
        if (node == null || node.next == null) return node;
        ListNode pre = null;
        while (node != null) {
            ListNode nxt = node.next;
            node.next = pre;
            pre = node;
            node = nxt;
        }
        return pre;
    }
    
    private ListNode getMid(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
