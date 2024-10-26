class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class SwapNodesInPairs24 {

    public ListNode swapPairs(ListNode head) {
        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode current = dummy; // Pointer to the current node

        while (current.next != null && current.next.next != null) {
            ListNode first = current.next; // First node in the pair
            ListNode second = current.next.next; // Second node in the pair
            
            // Swap the nodes
            first.next = second.next; // Point first to the node after second
            current.next = second; // Point current to the second node
            second.next = first; // Point second to the first node
            
            // Move current pointer to the next pair
            current = first;
        }
        
        return dummy.next; // Return the new head of the swapped list
    }

    public static void main(String[] args) {
        SwapNodesInPairs solution = new SwapNodesInPairs();
        
        // Create a sample linked list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        
        ListNode swappedHead = solution.swapPairs(head);
        
        // Print the swapped list
        while (swappedHead != null) {
            System.out.print(swappedHead.val + " ");
            swappedHead = swappedHead.next;
        }
    }
}



/*


Complexity Analysis
•	Time Complexity:
o	O(N)O(N)O(N), where NNN is the number of nodes in the linked list. We traverse the list once, swapping nodes in pairs.
•	Space Complexity:
o	O(1)O(1)O(1). We only use a fixed number of pointers for swapping, regardless of the input size.
Summary
This iterative approach to swapping nodes in pairs achieves:
•	Optimal Time Complexity: O(N)O(N)O(N)
•	Optimal Space Complexity: O(1)O(1)O(1)
*/
