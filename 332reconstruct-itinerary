import java.util.*;

public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        // Build the graph
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }
        
        // Start DFS from "JFK"
        dfs(graph, "JFK", result);
        
        return result;
    }
    
    private void dfs(Map<String, PriorityQueue<String>> graph, String airport, List<String> result) {
        PriorityQueue<String> destinations = graph.get(airport);
        
        // Visit all the destinations for the current airport
        while (destinations != null && !destinations.isEmpty()) {
            dfs(graph, destinations.poll(), result);
        }
        
        // Add the current airport to the result in reverse order of visiting
        result.add(0, airport);
    }
}
