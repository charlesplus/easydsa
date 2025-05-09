package dsa.solution.sort;

import dsa.solution.Solution;
import dsa.testcase.ListSortTestCaseSet;
import dsa.testcase.TestCaseSet;
import lombok.Getter;

import java.util.List;

public class BasicSortSolution implements Solution<List<Integer>, List<Integer>> {
    @Getter
    private static final BasicSortSolution instance = new BasicSortSolution();
    private BasicSortSolution() {
    }

    @Override
    public List<Integer> solve(List<Integer> input) {
        // bubble sort
        for (int i = 0; i < input.size()-1; i++) {
            for (int j = 0; j < input.size() - 1 - i; j++) {
                if (input.get(j) > input.get(j + 1)) {
                    int temp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                }
            }
        }

        // select sort
//        for (int i = 0; i < input.size() - 1; i++) {
//            int minIndex = i;
//            for (int j = i + 1; j < input.size(); j++) {
//                if (input.get(j) < input.get(minIndex)) {
//                    minIndex = j;
//                }
//            }
//            int temp = input.get(i);
//            input.set(i, input.get(minIndex));
//            input.set(minIndex, temp);
//        }

        return input;
    }

    @Override
    public TestCaseSet<List<Integer>, List<Integer>> getTestCaseSet() {
        return ListSortTestCaseSet.getInstance();
    }
}
