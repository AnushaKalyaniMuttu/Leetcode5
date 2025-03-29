import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {
    private Queue<Integer> queue;
    private int maxSize;
    private double sum;

    // Constructor to initialize the data structure
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        maxSize = size;
        sum = 0.0;
    }

    public double next(int val) {
        queue.add(val);
        sum += val;

        // Remove the oldest value if the queue exceeds the maximum size
        if (queue.size() > maxSize) {
            sum -= queue.poll();
        }

        // Return the average of the current window
        return sum / queue.size();
    }
}
