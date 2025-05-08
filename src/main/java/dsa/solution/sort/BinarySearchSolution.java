package dsa.solution.sort;

import dsa.solution.Solution;
import dsa.testcase.ListSearchTestCaseSet;
import dsa.testcase.TestCaseSet;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class BinarySearchSolution implements Solution<Pair<List<Integer>, Integer>, Integer> {

    @Override
    public Integer solve(Pair<List<Integer>, Integer> input) {
        return null;
    }

    @Override
    public TestCaseSet<Pair<List<Integer>, Integer>, Integer> getTestCaseSet() {
        return ListSearchTestCaseSet.getInstance();
    }
}
