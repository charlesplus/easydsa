package dsa.testcase;

import dsa.checker.Checker;
import dsa.checker.GeneralChecker;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class ListSearchTestCaseSet implements TestCaseSet<Pair<List<Integer>, Integer>, Integer> {
    // singleton
    private static ListSearchTestCaseSet instance = new ListSearchTestCaseSet();
    private ListSearchTestCaseSet() {
    }
    public static ListSearchTestCaseSet getInstance() {
        return instance;
    }

    @Override
    public List<Pair<Pair<List<Integer>, Integer>, Integer>> getTestCases() {
        return Arrays.asList(
            Pair.of(Pair.of(Arrays.asList(1, 2, 3, 4, 5), 3), 2),
            Pair.of(Pair.of(Arrays.asList(1, 2, 3, 4, 5), 6), -1),
            Pair.of(Pair.of(Arrays.asList(1, 2, 3, 4, 5), -1), -1),
            Pair.of(Pair.of(Arrays.asList(), 1), -1),
            Pair.of(Pair.of(Arrays.asList(1), 1), 0)
        );
    }

}
