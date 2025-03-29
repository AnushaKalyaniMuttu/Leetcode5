class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Move `prev` to the node just before `left`
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Start the reversal process
        ListNode current = prev.next; // The first node to be reversed
        ListNode then = current.next; // The node that will be reversed

        // Step 2: Reverse the sublist
        for (int i = 0; i < right - left; i++) {
            current.next = then.next; // Link current to the next node after `then`
            then.next = prev.next;     // Link `then` to the front of the reversed part
            prev.next = then;          // Move `then` to the front of the reversed part
            then = current.next;       // Move `then` to the next node to be reversed
        }

        // Step 3: Return the new head
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reverse from position 2 to 4
        ListNode result = solution.reverseBetween(head, 2, 4);

        // Print the modified linked list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Output: 1 4 3 2 5
    }
}
