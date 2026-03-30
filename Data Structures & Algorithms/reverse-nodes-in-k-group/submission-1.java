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
            cur = cur.next;
            n++;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        cur = dummy;
        while (n >= k) {
            n -= k;
            ListNode pre = null;
            ListNode groupHead = cur.next;
            ListNode node = groupHead;
            int i = 0;
            while (i < k) {
                i++;
                ListNode nxt = node.next;
                node.next = pre;
                pre = node;
                node = nxt;
            }
            cur.next = pre;
            groupHead.next = node;
            cur = groupHead;
        }
        return dummy.next;
    }
    
}
