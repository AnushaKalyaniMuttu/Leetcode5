import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Solution {

    public List<String> processList(List<String> list) {
        return list.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("hi");
        list.add("hello");
        list.add("java");
        list.add("world");

        List<String> result = solution.processList(list);

        System.out.println(result); // Output: [HELLO, JAVA, WORLD]
    }
}
