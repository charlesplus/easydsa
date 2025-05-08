package dsa.testcase;

import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListSearchTestCaseSet implements TestCaseSet<Pair<List<Integer>, Integer>, Integer> {
    // singleton
    @Getter
    private final static ListSearchTestCaseSet instance = new ListSearchTestCaseSet();
    private ListSearchTestCaseSet() {
    }

    @Override
    public List<Pair<Pair<List<Integer>, Integer>, Integer>> getTestCases() {
        return Arrays.asList(
            Pair.of(Pair.of(Arrays.asList(1, 2, 3, 4, 5), 3), 2),
            Pair.of(Pair.of(Arrays.asList(1, 2, 3, 4, 5), 6), -1),
            Pair.of(Pair.of(Arrays.asList(1, 2, 3, 4, 5), -1), -1),
            Pair.of(Pair.of(Collections.emptyList(), 1), -1),
            Pair.of(Pair.of(Collections.singletonList(1), 1), 0)
        );
    }

}
