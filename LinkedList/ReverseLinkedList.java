// Problem: Reverse Linked List (LeetCode 206)
// Approaches: Recursive & Iterative


class Solution {

    // Recursive Approach
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = head;
        if (head.next != null) {
            newHead = reverseListRecursive(head.next);
            head.next.next = head;
        }
        head.next = null;

        return newHead;
    }

    // Iterative Approach
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next; // store next node
            curr.next = prev;          // reverse current node's pointer
            prev = curr;               // move prev to current
            curr = temp;               // move curr to next
        }
        return prev; // new head
    }
}

/*
---------------------------------------------------------
Approach Explanation
---------------------------------------------------------

1. Recursive Approach:
   - We go to the end of the linked list using recursion.
   - On the way back (unwinding recursion), we reverse the pointers.
   - Example:
       head -> next -> next.next ...
       At the deepest call, we get the last node (newHead).
       Then we set: head.next.next = head (reverse link).
       Finally, set head.next = null to break old link.

   Time Complexity: O(n)  → each node visited once
   Space Complexity: O(n) → recursion stack

2. Iterative Approach (Optimal):
   - Use three pointers: `prev`, `curr`, `temp`.
   - Traverse the list and reverse each node's pointer step by step.
   - Keep updating `prev` as the new head while moving forward.
   - At the end, `prev` will point to the new head of the reversed list.

   Time Complexity: O(n)  → each node visited once
   Space Complexity: O(1) → constant extra space

---------------------------------------------------------
*/
