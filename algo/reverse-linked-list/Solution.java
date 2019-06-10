/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverseListIter(head);
        //return reverseListRec(head).head;
    }

    private ListNode reverseListIter(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode i = head;
        while(i != null) {
            stack.push(i);
            i = i.next;
        }
        ListNode newHead = new ListNode(stack.poll().val);
        i = newHead;
        for (ListNode node: stack) {
            i.next = new ListNode(node.val);
            i = i.next;
        }
        return newHead;
    }
    
    private Pair reverseListRec(ListNode head) {
        if (head.next == null) {
            ListNode node = new ListNode(head.val);
            return new Pair(node, node);
        }
        Pair pair = reverseListRec(head.next);
        pair.next.next = new ListNode(head.val);
        return new Pair(pair.head, pair.next.next);
    }
    
    private class Pair {
        public ListNode head;
        public ListNode next;

        Pair(ListNode head, ListNode next) {
            this.head = head;
            this.next = next;
        }
    }
    
}
