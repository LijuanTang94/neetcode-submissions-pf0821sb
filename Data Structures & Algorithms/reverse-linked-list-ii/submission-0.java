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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        for(int i = 0; i < left - 1; i++) {
            cur = cur.next;
        }
        ListNode prevTail = cur;
        ListNode nextTail = prevTail.next;
        ListNode pre = null;
        cur = nextTail;
        for(int i = left; i <= right; i++) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        prevTail.next = pre;
        nextTail.next = cur;
        return dummy.next;
    }
}