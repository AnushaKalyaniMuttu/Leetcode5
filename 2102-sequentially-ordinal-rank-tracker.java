import java.util.*;

class SORTracker {

    private PriorityQueue<Node> left;  // max heap
    private PriorityQueue<Node> right; // min heap
    private int k;

    class Node {
        String name;
        int score;

        Node(String n, int s) {
            name = n;
            score = s;
        }
    }

    public SORTracker() {
        k = 0;

        // max heap (worst among best k at top)
        left = new PriorityQueue<>((a, b) -> {
            if (a.score == b.score) return b.name.compareTo(a.name);
            return a.score - b.score;
        });

        // min heap (best among remaining at top)
        right = new PriorityQueue<>((a, b) -> {
            if (a.score == b.score) return a.name.compareTo(b.name);
            return b.score - a.score;
        });
    }

    public void add(String name, int score) {
        Node node = new Node(name, score);

        right.offer(node);
        left.offer(right.poll());

        if (left.size() > k) {
            right.offer(left.poll());
        }
    }

    public String get() {
        k++;
        left.offer(right.poll());
        return left.peek().name;
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */
