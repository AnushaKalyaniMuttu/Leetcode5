class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0); // Dummy head for less than x
        ListNode greaterHead = new ListNode(0); // Dummy head for greater than or equal to x
        ListNode less = lessHead;
        ListNode greater = greaterHead;

        // Traverse the original list
        while (head != null) {
            if (head.val < x) {
                less.next = head; // Add to the less list
                less = less.next;
            } else {
                greater.next = head; // Add to the greater list
                greater = greater.next;
            }
            head = head.next; // Move to the next node
        }

        // Connect the two lists
        greater.next = null; // Important to avoid cycle in the list
        less.next = greaterHead.next; // Connect less list to greater list

        return lessHead.next; // Return the head of the new partitioned list
    }
}

/*
Time Complexity
The algorithm runs in O(n) time, where n is the number of nodes in the linked list,
  since each node is processed once. The space complexity is O(1), as we are using only a fixed amount of extra space for the pointers
  */
