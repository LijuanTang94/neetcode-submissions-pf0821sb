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
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for(ListNode l: lists) {
            if (l != null) {
                pq.offer(l);
            }
        }
        while (!pq.isEmpty()) {
            ListNode list = pq.poll();
            cur.next = list;
            if (list.next != null) {
                pq.offer(list.next);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
