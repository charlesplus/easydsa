package dsa.solution.search;

import dsa.solution.Solution;
import dsa.testcase.ListSearchTestCaseSet;
import dsa.testcase.TestCaseSet;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class BinarySearchSolution implements Solution<Pair<List<Integer>,Integer>, Integer> {

    // singleton
    @Getter
    private static final BinarySearchSolution instance = new BinarySearchSolution();
    private BinarySearchSolution() {
    }

    @Override
    public Integer solve(Pair<List<Integer>, Integer> input) {
        List<Integer> list = input.getLeft();
        Integer target = input.getRight();
//        int left = 0;
//        int right = list.size() - 1;
//
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (list.get(mid).equals(target)) {
//                return mid;
//            } else if (list.get(mid) < target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }

        // recursive
        return binarySearch(list, target, 0, list.size() - 1);
    }
    private Integer binarySearch(List<Integer> list, Integer target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (list.get(mid).equals(target)) {
            return mid;
        } else if (list.get(mid) < target) {
            return binarySearch(list, target, mid + 1, right);
        } else {
            return binarySearch(list, target, left, mid - 1);
        }
    }

    @Override
    public TestCaseSet<Pair<List<Integer>, Integer>, Integer> getTestCaseSet() {
        return ListSearchTestCaseSet.getInstance();
    }
}
