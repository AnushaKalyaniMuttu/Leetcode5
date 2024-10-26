class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify code
        ListNode current = dummy; // Pointer to construct the new list

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1; // Attach l1 node
                l1 = l1.next; // Move l1 pointer
            } else {
                current.next = l2; // Attach l2 node
                l2 = l2.next; // Move l2 pointer
            }
            current = current.next; // Move current pointer
        }

        // Attach the remaining nodes
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next; // Return the merged list, skipping the dummy node
    }

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        // Create first sorted list: 1 -> 2 -> 4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        // Create second sorted list: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode mergedHead = solution.mergeTwoLists(l1, l2);
        
        // Print the merged list
        while (mergedHead != null) {
            System.out.print(mergedHead.val + " ");
            mergedHead = mergedHead.next;
        }
    }
}
/* 
Time Complexity O(N+M)
Space Complexity O(1)

  */
