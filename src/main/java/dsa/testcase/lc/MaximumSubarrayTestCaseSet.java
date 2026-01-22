package dsa.testcase.lc;

import dsa.testcase.TestCaseSet;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class MaximumSubarrayTestCaseSet implements TestCaseSet<int[], Integer> {
    @Getter
    public static final MaximumSubarrayTestCaseSet instance = new MaximumSubarrayTestCaseSet();
    private MaximumSubarrayTestCaseSet() {
    }

    @Override
    public List<Pair<int[], Integer>> getTestCases() {
        return Arrays.asList(
            // Test case 1: [-2,1,-3,4,-1,2,1,-5,4] -> 6 ([4,-1,2,1])
            Pair.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
            // Test case 2: [1] -> 1
            Pair.of(new int[]{1}, 1),
            // Test case 3: [5,4,-1,7,8] -> 23
            Pair.of(new int[]{5, 4, -1, 7, 8}, 23),
            // Test case 4: [-1] -> -1
            Pair.of(new int[]{-1}, -1)
        );
    }
}