package dsa.solution.sort;

import dsa.annotation.RunSolution;
import dsa.solution.Solution;
import dsa.testcase.ListSortTestCaseSet;
import dsa.testcase.TestCaseSet;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@RunSolution(runByDefault = true)
public class MergeSortSolution implements Solution<List<Integer>, List<Integer>> {
    @Getter
    private static final MergeSortSolution instance = new MergeSortSolution();
    private MergeSortSolution() {
    }

    @Override
    public List<Integer> solve(List<Integer> integers) {
        if (integers == null || integers.size() <= 1) {
            return integers;
        }
        mergeSort(integers, 0, integers.size() - 1);
        return integers;
    }

    private void mergeSort(List<Integer> integers, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2; // 避免整数溢出
        mergeSort(integers, left, mid);
        mergeSort(integers, mid + 1, right);
        merge(integers, left, mid, right);
    }

    private void merge(List<Integer> integers, int left, int mid, int right) {
        // 创建临时副本，而不是使用subList的视图
        List<Integer> leftList = new ArrayList<>(integers.subList(left, mid + 1));
        List<Integer> rightList = new ArrayList<>(integers.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i) <= rightList.get(j)) {
                integers.set(k++, leftList.get(i++));
            } else {
                integers.set(k++, rightList.get(j++));
            }
        }
        while (i < leftList.size()) {
            integers.set(k++, leftList.get(i++));
        }
        while (j < rightList.size()) {
            integers.set(k++, rightList.get(j++));
        }
    }


    @Override
    public TestCaseSet<List<Integer>, List<Integer>> getTestCaseSet() {
        return ListSortTestCaseSet.getInstance();
    }
}
