public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Compute the length of the list
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Connect the tail to the head to make it circular
        current.next = head;

        // Step 3: Find the new tail and the new head
        k = k % length; // Handle cases where k >= length
        int newTailPosition = length - k;
        ListNode newTail = head;
        for (int i = 1; i < newTailPosition; i++) {
            newTail = newTail.next;
        }
        
        // Step 4: Define the new head
        ListNode newHead = newTail.next;

        // Step 5: Break the cycle
        newTail.next = null;

        return newHead;
    }
}



/*

Complexity Analysis:
•	Time Complexity: O(n)O(n)O(n) because we traverse the list to find the length and then again to find the new tail.
•	Space Complexity: O(1)O(1)O(1) since we only use a constant amount of extra space.



*/
