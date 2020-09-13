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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        } else {
            ListNode small = l1, big = l2;
            if (l1.val > l2.val) {
                small = l2;
                big = l1;
            }  
            small.next = mergeTwoLists(small.next, big);
            return small;
        }
    }
}