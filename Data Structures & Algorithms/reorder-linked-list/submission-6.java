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
        ListNode r = reverse(mid);
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
    private ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        return pre;
    }
}
