package dsa;

import dsa.solution.lc.ListNodePartialReverseSolution;
import dsa.solution.lc.ListNodeReverseSolution;
import dsa.solution.search.BinarySearchSolution;
import dsa.solution.sort.BasicSortSolution;
import dsa.solution.sort.MergeSortSolution;
import dsa.solution.sort.QuickSortSolution;
import dsa.solution.tree.BinaryTreeBfsSolution;
import dsa.solution.tree.BinaryTreeDfsSolution;
import dsa.solution.leetcode.*;

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

        // LeetCode classic problems
        TwoSumSolution.getInstance().runTest();
        ValidParenthesesSolution.getInstance().runTest();
        MergeTwoSortedListsSolution.getInstance().runTest();
        BestTimeToBuyAndSellStockSolution.getInstance().runTest();
        MaximumSubarraySolution.getInstance().runTest();
        ClimbingStairsSolution.getInstance().runTest();
        LongestCommonPrefixSolution.getInstance().runTest();
        PalindromeNumberSolution.getInstance().runTest();
        RemoveDuplicatesFromSortedArraySolution.getInstance().runTest();
        RotateImageSolution.getInstance().runTest();
        GroupAnagramsSolution.getInstance().runTest();
        SpiralMatrixSolution.getInstance().runTest();
        UniquePathsSolution.getInstance().runTest();
        WordSearchSolution.getInstance().runTest();
    }
}