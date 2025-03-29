class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class RemoveDuplicatesFromSortedListII82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            // Check if the current node is a duplicate
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with the same value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Connect the last non-duplicate node to the next node
                prev.next = head.next; 
            } else {
                // Move prev pointer only if no duplicates were found
                prev = prev.next; 
            }
            // Move head pointer forward
            head = head.next; 
        }
        
        return dummy.next; // Return the new head of the modified list
    }
}
/*
Time Complexity
The algorithm runs in O(n) time, where n is the number of nodes in the linked list, as each node is processed at most twice. The space complexity is O(1) since we are modifying the list in place.
  */
