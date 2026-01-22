package dsa;

import dsa.solution.lc.ListNodePartialReverseSolution;
import dsa.solution.lc.ListNodeReverseSolution;
import dsa.solution.search.BinarySearchSolution;
import dsa.solution.sort.BasicSortSolution;
import dsa.solution.sort.MergeSortSolution;
import dsa.solution.sort.QuickSortSolution;
import dsa.solution.tree.BinaryTreeBfsSolution;
import dsa.solution.tree.BinaryTreeDfsSolution;

public class Main {
    public static void main(String[] args) {
        BasicSortSolution.getInstance().runTest();
        QuickSortSolution.getInstance().runTest();
        MergeSortSolution.getInstance().runTest();
        BinarySearchSolution.getInstance().runTest();
        BinaryTreeBfsSolution.getInstance().runTest();
        BinaryTreeDfsSolution.getInstance().runTest();
        ListNodeReverseSolution.getInstance().runTest();
        ListNodePartialReverseSolution.getInstance().runTest();
    }
}