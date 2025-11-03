/**
 * Problem: Remove Nth Node From End of List (LeetCode #19)
 *
 * Approach:
 * 1. Count total nodes in the list.
 * 2. If n == total nodes, remove the head.
 * 3. Otherwise, move to the (count - n - 1)th node and skip the next node.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count = 0;

        // Step 1: Count nodes
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Step 2: If head needs to be removed
        if (n == count) {
            return head.next;
        }

        // Step 3: Find node before the one to delete
        int target = count - n;
        temp = head;
        int idx = 0;

        while (idx != target - 1) {
            temp = temp.next;
            idx++;
        }

        // Step 4: Delete the node
        temp.next = temp.next.next;

        return head;
    }
}
