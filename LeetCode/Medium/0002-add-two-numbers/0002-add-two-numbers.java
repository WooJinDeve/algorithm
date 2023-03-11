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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        return calculator(l1, l2, null, 0, 0);
    }

    private ListNode calculator(ListNode l1, ListNode l2, ListNode node, int depth, int plus) {
        if (l1 == null && l2 == null){
            return plus > 0 ? addLast(node,plus) : node;
        }

        int a = l1 != null ? l1.val : 0;
        int b = l2 != null ? l2.val : 0;
        int c = a + b + plus;

        node = addLast(node, c % 10);
        calculator(l1 != null ? l1.next : l1, l2 != null ? l2.next : l2, node, depth + 1, c / 10);
        return node;
    }

    public static ListNode addLast(ListNode header, int value) {
        ListNode node = header;

        if (header == null) {
            return new ListNode(value, null);
        }

        while (header.next != null) {
            header = header.next;
        }

        header.next = new ListNode(value, null);
        return node;
    }
}