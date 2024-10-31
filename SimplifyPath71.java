import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                // Skip empty or current directory
                continue;
            } else if (component.equals("..")) {
                // Go back to the parent directory
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Push the valid directory to the stack
                stack.push(component);
            }
        }

        // Build the final simplified path
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }

        // If the stack is empty, return "/"
        return simplifiedPath.length() == 0 ? "/" : simplifiedPath.toString();
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        String path = "/a/./b/../../c/";
        System.out.println(sp.simplifyPath(path)); // Output: "/c"
    }
}

/*
Time Complexity
The time complexity is O(n), where n is the length of the path string, since we process each component once.
Space Complexity
The space complexity is O(n) in the worst case, where the path has all valid components.

*/
