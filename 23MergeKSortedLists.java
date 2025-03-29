 import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class MergeKSortedLists23 {

    public ListNode mergeKLists(ListNode[] lists) {
        // Min-heap (priority queue)
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the head of each list to the min-heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            ListNode smallestNode = minHeap.poll(); // Get the smallest node
            current.next = smallestNode; // Add it to the merged list
            current = current.next; // Move to the next position
            
            // If there is a next node, add it to the min-heap
            if (smallestNode.next != null) {
                minHeap.offer(smallestNode.next);
            }
        }

        return dummy.next; // Return the merged list, skipping the dummy node
    }

    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();
        
        // Example with 3 sorted linked lists
        ListNode[] lists = new ListNode[3];
        
        // Create first sorted list: 1 -> 4 -> 5
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        
        // Create second sorted list: 1 -> 3 -> 4
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        
        // Create third sorted list: 2 -> 6
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        
        ListNode mergedHead = solution.mergeKLists(lists);
        
        // Print the merged list
        while (mergedHead != null) {
            System.out.print(mergedHead.val + " ");
            mergedHead = mergedHead.next;
        }
    }
}


/*



Complexity Analysis
•	Time Complexity:
o	The time complexity is O(Nlog⁡k)O(N \log k)O(Nlogk), where NNN is the total number of nodes across all lists, and kkk is the number of lists. Each insertion and extraction from the heap takes O(log⁡k)O(\log k)O(logk), and you perform these operations NNN times.
•	Space Complexity:
o	The space complexity is O(k)O(k)O(k) for the min-heap, as you only store the heads of the kkk lists in the heap at any given time.
Summary
Using a min-heap to merge kkk sorted linked lists provides:
•	Optimal Time Complexity: O(Nlog⁡k)O(N \log k)O(Nlogk)
•	Optimal Space Complexity: O(k)O(k)O(k)



  */
