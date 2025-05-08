package dsa.testcase;

import dsa.checker.Checker;
import dsa.checker.ListChecker;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListSortTestCaseSet implements TestCaseSet<List<Integer>, List<Integer>> {
    @Getter
    private final static ListSortTestCaseSet instance = new ListSortTestCaseSet();
    private ListSortTestCaseSet() {
    }

    @Override
    public List<Pair<List<Integer>, List<Integer>>> getTestCases() {
        return Arrays.asList(
                Pair.of( Arrays.asList(3, 1, 2),  Arrays.asList(1, 2, 3)),
                Pair.of( Arrays.asList(5, 4, 3, 2, 1),  Arrays.asList(1, 2, 3, 4, 5)),
                Pair.of(Collections.emptyList(), Collections.emptyList()),
                Pair.of(Collections.singletonList(1), Collections.singletonList(1)),
                Pair.of( Arrays.asList(2, 2, 2),  Arrays.asList(2, 2, 2)),
                Pair.of( Arrays.asList(1, 2, 3, 4, 5),  Arrays.asList(1, 2, 3, 4, 5)),
                Pair.of( Arrays.asList(1, 3, 2),  Arrays.asList(1, 2, 3)),
                Pair.of( Arrays.asList(1, 2, 3, 5, 4),  Arrays.asList(1, 2, 3, 4, 5))
        );
    }

    @Override
    public Checker<List> getChecker() {
        return ListChecker.getInstance();
    }
}
