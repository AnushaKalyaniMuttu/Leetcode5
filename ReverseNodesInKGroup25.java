class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class ReverseNodesInKGroup25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy; // Pointer to the end of the previous group

        while (true) {
            ListNode kthNode = getKthNode(prevGroupEnd, k);
            if (kthNode == null) break; // Not enough nodes left to reverse

            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kthNode.next;
            kthNode.next = null; // Temporarily break the chain
            
            // Reverse the current group
            ListNode reversedGroupHead = reverse(groupStart);
            
            // Connect the previous group with the reversed group
            prevGroupEnd.next = reversedGroupHead;
            groupStart.next = nextGroupStart;
            prevGroupEnd = groupStart; // Move to the end of the new group
        }

        return dummy.next; // Return the new head of the modified list
    }

    private ListNode getKthNode(ListNode start, int k) {
        ListNode current = start;
        for (int i = 0; i < k; i++) {
            if (current == null) return null; // Not enough nodes
            current = current.next;
        }
        return current; // Return the kth node
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextTemp = head.next; // Store the next node
            head.next = prev; // Reverse the link
            prev = head; // Move prev to the current node
            head = nextTemp; // Move to the next node
        }
        return prev; // Return the new head of the reversed list
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
        
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        int k = 3; // Example group size
        ListNode newHead = solution.reverseKGroup(head, k);
        
        // Print the modified list
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}



/*


Complexity Analysis
•	Time Complexity:
o	O(N)O(N)O(N), where NNN is the number of nodes in the linked list. Each node is processed a constant number of times.
•	Space Complexity:
o	O(1)O(1)O(1). The algorithm only uses a fixed number of pointers regardless of the input size, thus maintaining constant space complexity.
Summary
This implementation is efficient and straightforward, providing:
•	Optimal Time Complexity: O(N)O(N)O(N)
•	Optimal Space Complexity: O(1)O(1)O(1)

*/
