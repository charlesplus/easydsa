package dsa.testcase.lc;

import dsa.testcase.TestCaseSet;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesFromSortedArrayTestCaseSet implements TestCaseSet<int[], Integer> {
    @Getter
    public static final RemoveDuplicatesFromSortedArrayTestCaseSet instance = new RemoveDuplicatesFromSortedArrayTestCaseSet();
    private RemoveDuplicatesFromSortedArrayTestCaseSet() {
    }

    @Override
    public List<Pair<int[], Integer>> getTestCases() {
        return Arrays.asList(
            // Test case 1: [1,1,2] -> 2, nums = [1,2,_]
            Pair.of(new int[]{1, 1, 2}, 2),
            // Test case 2: [0,0,1,1,1,2,2,3,3,4] -> 5, nums = [0,1,2,3,4,_,_,_,_,_]
            Pair.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5),
            // Test case 3: [1] -> 1
            Pair.of(new int[]{1}, 1),
            // Test case 4: [1,1,1,1] -> 1
            Pair.of(new int[]{1, 1, 1, 1}, 1)
        );
    }
}