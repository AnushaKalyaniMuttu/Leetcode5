import java.util.*;

class SnakeGame {
    private Set<Integer> set; 
    private Deque<Integer> deque; 
    private int score; 
    private int foodIndex; 
    private int width; 
    private int height; 
    private int[][] food;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.set = new HashSet<>();
        this.deque = new LinkedList<>();
        this.score = 0;
        this.foodIndex = 0;

        deque.offerLast(0); 
        set.add(0); 
    }

    public int move(String direction) {
        int headRow = deque.peekFirst() / width;
        int headCol = deque.peekFirst() % width;

        switch (direction) {
            case "U": headRow--; break;
            case "D": headRow++; break;
            case "L": headCol--; break;
            case "R": headCol++; break;
            default: return -1; 
        }

        int newHead = headRow * width + headCol;

        if (headRow < 0 || headRow >= height || headCol < 0 || headCol >= width) return -1;

        if (set.contains(newHead) && newHead != deque.peekLast()) return -1;

        if (foodIndex < food.length && headRow == food[foodIndex][0] && headCol == food[foodIndex][1]) {
            score++;
            foodIndex++;
        } else {
            int tail = deque.pollLast();
            set.remove(tail);
        }

        deque.offerFirst(newHead);
        set.add(newHead);

        return score;
    }
}
