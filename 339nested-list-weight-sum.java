import java.util.List;

public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSumHelper(nestedList, 1);
    }

    private int depthSumHelper(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += depthSumHelper(ni.getList(), depth + 1);
            }
        }
        return sum;
    }
}
