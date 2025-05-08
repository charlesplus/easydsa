package dsa.solution.sort;

import dsa.solution.Solution;
import dsa.testcase.ListSortTestCaseSet;
import dsa.testcase.TestCaseSet;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

public class QuickSortSolution implements Solution<List<Integer>, List<Integer>> {
    @Getter
    private static final QuickSortSolution instance = new QuickSortSolution();
    private QuickSortSolution() {
    }

    @Override
    public List<Integer> solve(List<Integer> integers) {
        if (integers == null || integers.size() <= 1) {
            return integers;
        }
        quickSort(integers, 0, integers.size() - 1);
        return integers;
    }

    private void quickSort(List<Integer> integers, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = integers.get((left + right) / 2);
        int index = partition(integers, left, right, pivot);
        quickSort(integers, left, index - 1);
        quickSort(integers, index, right);
    }

    private int partition(List<Integer> integers, int left, int right, int pivot) {
        while (left <= right) {
            while (integers.get(left) < pivot) {
                left++;
            }
            while (integers.get(right) > pivot) {
                right--;
            }
            if (left <= right) {
                Collections.swap(integers, left, right);
                left++;
                right--;
            }
        }
        return left;
    }


    @Override
    public TestCaseSet<List<Integer>, List<Integer>> getTestCaseSet() {
        return ListSortTestCaseSet.getInstance();
    }
}
