package dsa.testcase.lc;

import dsa.testcase.TestCaseSet;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class ClimbingStairsTestCaseSet implements TestCaseSet<Integer, Integer> {
    @Getter
    public static final ClimbingStairsTestCaseSet instance = new ClimbingStairsTestCaseSet();
    private ClimbingStairsTestCaseSet() {
    }

    @Override
    public List<Pair<Integer, Integer>> getTestCases() {
        return Arrays.asList(
            // Test case 1: n=2 -> 2
            Pair.of(2, 2),
            // Test case 2: n=3 -> 3
            Pair.of(3, 3),
            // Test case 3: n=4 -> 5
            Pair.of(4, 5),
            // Test case 4: n=5 -> 8
            Pair.of(5, 8)
        );
    }
}