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
