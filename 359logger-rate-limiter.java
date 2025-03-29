import java.util.HashMap;
import java.util.Map;

class Logger {
    private Map<String, Integer> messageTimestamp;

    public Logger() {
        messageTimestamp = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTimestamp.containsKey(message)) {
            messageTimestamp.put(message, timestamp);
            return true;
        }
        
        int lastTimestamp = messageTimestamp.get(message);
        if (timestamp - lastTimestamp >= 10) {
            messageTimestamp.put(message, timestamp);
            return true;
        }

        return false;
    }
}
