import java.util.*;

class SnakeGame {
    private int width, height;
    private int[][] food;
    private int foodIndex;
    private int score;
    private Set<Integer> snakeSet; // To track snake positions
    private Deque<Integer> snakeQueue; // To maintain the snake's body

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.foodIndex = 0;
        this.score = 0;
        this.snakeSet = new HashSet<>();
        this.snakeQueue = new LinkedList<>();

        // Initialize snake at position (0, 0)
        snakeQueue.offerLast(0);
        snakeSet.add(0);
    }
    
    public int move(String direction) {
        // Get current head position
        int row = snakeQueue.peekFirst() / width;
        int col = snakeQueue.peekFirst() % width;

        // Determine the new head position
        switch (direction) {
            case "U": row--; break;
            case "D": row++; break;
            case "L": col--; break;
            case "R": col++; break;
            default: return -1; // Invalid direction
        }

        // Compute the new head position index
        int newHead = row * width + col;

        // Check if the new head position is out of bounds
        if (row < 0 || row >= height || col < 0 || col >= width) {
            return -1;
        }

        // Check if the new head position collides with the snake's body
        if (snakeSet.contains(newHead) && newHead != snakeQueue.peekLast()) {
            return -1;
        }

        // Check if the new head position is at the food location
        if (foodIndex < food.length && row == food[foodIndex][0] && col == food[foodIndex][1]) {
            score++;
            foodIndex++;
        } else {
            // Remove the tail from the snake's body
            int tail = snakeQueue.pollLast();
            snakeSet.remove(tail);
        }

        // Add the new head position to the snake's body
        snakeQueue.offerFirst(newHead);
        snakeSet.add(newHead);

        return score;
    }
}
