package dsa.solution;

import dsa.testcase.TestCaseSet;
import org.apache.commons.lang3.tuple.Pair;

public interface Solution<T, R> {

    R solve(T input);

    TestCaseSet<T, R> getTestCaseSet();

    default Pair<Integer, Integer> runTest() {
        // print start log
        System.out.printf("Running %s -> %s ...%n", this.getClass().getSimpleName(),
                getTestCaseSet().getClass().getSimpleName());
        Pair<Integer, Integer> check = getTestCaseSet().check(this);
        System.out.printf("%s -> %s: %d/%d passed%n", this.getClass().getSimpleName(),
                getTestCaseSet().getClass().getSimpleName(), check.getLeft(), check.getRight());
        return check;
    }
}
