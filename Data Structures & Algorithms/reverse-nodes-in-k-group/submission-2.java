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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode groupHead = dummy;
        cur = head;
        while (n >= k) {
            n -= k;
            ListNode pre = null;
            int start = 0;
            ListNode tail = cur;
            while (start < k) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
                start++;
            }
            groupHead.next = pre;
            tail.next = cur;
            groupHead = tail;
        }
        return dummy.next;
    }
}
