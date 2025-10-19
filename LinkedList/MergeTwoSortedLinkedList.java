class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

/*
Approach:
- This solution uses recursion to merge two sorted linked lists.
- Base case: if either list is null, return the other list.
- Compare the head nodes of both lists:
    - The smaller node becomes part of the merged list.
    - Recursively merge the rest of the nodes.
- The function builds the merged list in sorted order as recursion unwinds.

Time Complexity: O(n + m)
- Where n and m are the lengths of the two linked lists.
- Each node is visited exactly once.

Space Complexity: O(n + m)
- Due to recursive call stack space used when merging both lists.
*/

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummy.next;
    }
}

/*
Approach:
- Use an iterative approach with a dummy node to simplify merging.
- Initialize a dummy node and a pointer `temp` to track the merged list.
- Traverse both lists until one becomes null:
    - Compare the current nodes of both lists.
    - Append the smaller node to `temp.next` and move that list’s pointer forward.
- After the loop, attach the remaining nodes (if any) from the non-null list.
- Finally, return `dummy.next` as the head of the merged sorted list.

Time Complexity: O(n + m)
- Each node from both lists is visited exactly once.

Space Complexity: O(1)
- Only constant extra space is used (no recursion or additional data structures).
*/
