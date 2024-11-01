class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode current = head;

        while (current != null && current.next != null) {
            // If current node value is the same as the next node value
            if (current.val == current.next.val) {
                // Skip the next node
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        return head; // Return the modified linked list
    }
}
/*
Time Complexity
The algorithm runs in O(n) time, where n is the number of nodes in the linked list, since we only traverse the list once. The space complexity is O(1) 
  */
