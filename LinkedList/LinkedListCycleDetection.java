/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // Traverse the list
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow pointer one step
            fast = fast.next.next;  // Move fast pointer two steps
            
            // Check if slow and fast meet, indicating a cycle
            if (slow == fast) {
                return true;
            }
        }
        
        // If we reach here, there's no cycle
        return false;
    }
}

/*
Approach:
- This uses Floyd’s Cycle Detection Algorithm (Tortoise and Hare approach).
- Maintain two pointers: 
    - `slow` moves one step at a time.
    - `fast` moves two steps at a time.
- If the linked list contains a cycle, the two pointers will eventually meet.
- If `fast` or `fast.next` becomes null, it means the list has no cycle.

Time Complexity: O(n)
- Each node is visited at most twice (once by each pointer).

Space Complexity: O(1)
- No extra data structures are used; only two pointers are maintained.
*/
