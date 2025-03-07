/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    private Stack<Iterator<NestedInteger>> stack;
    private Integer nextValue;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.iterator());
        nextValue = null;
    }

    @Override
    public Integer next() {
        if (nextValue == null) {
            findNext();
        }
        Integer value = nextValue;
        nextValue = null;
        return value;
    }

    @Override
    public boolean hasNext() {
        if (nextValue != null) {
            return true;
        }
        findNext();
        return nextValue != null;
    }

    private void findNext() {
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                continue;
            }

            NestedInteger current = iterator.next();
            if (current.isInteger()) {
                nextValue = current.getInteger();
                return;
            } else {
                stack.push(current.getList().iterator());
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
