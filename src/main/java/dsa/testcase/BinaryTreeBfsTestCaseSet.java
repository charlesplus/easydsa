package dsa.testcase;

import dsa.testcase.ds.BinaryTreeNode;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryTreeBfsTestCaseSet implements TestCaseSet<BinaryTreeNode<Integer>, List<Integer>> {
    //singleton
    @Getter
    private final static BinaryTreeBfsTestCaseSet instance = new BinaryTreeBfsTestCaseSet();
    private BinaryTreeBfsTestCaseSet() {
    }


    @Override
    public List<Pair<BinaryTreeNode<Integer>, List<Integer>>> getTestCases() {
        // 创建10组测试用例，包含非完全二叉树，这样尽可能评估算法准确性
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> left = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> right = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> leftLeft = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> leftRight = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> rightLeft = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> rightRight = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> leftLeftLeft = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> leftLeftRight = new BinaryTreeNode<>(9);
        BinaryTreeNode<Integer> leftRightLeft = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> leftRightRight = new BinaryTreeNode<>(11);
        BinaryTreeNode<Integer> rightLeftLeft = new BinaryTreeNode<>(12);
        BinaryTreeNode<Integer> rightLeftRight = new BinaryTreeNode<>(13);
        BinaryTreeNode<Integer> rightRightLeft = new BinaryTreeNode<>(14);
        BinaryTreeNode<Integer> rightRightRight = new BinaryTreeNode<>(15);
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(leftLeft);
        left.setRight(leftRight);
        right.setLeft(rightLeft);
        right.setRight(rightRight);
        leftLeft.setLeft(leftLeftLeft);
        leftLeft.setRight(leftLeftRight);
        leftRight.setLeft(leftRightLeft);
        leftRight.setRight(leftRightRight);
        rightLeft.setLeft(rightLeftLeft);
        rightLeft.setRight(rightLeftRight);
        rightRight.setLeft(rightRightLeft);
        rightRight.setRight(rightRightRight);
        return Arrays.asList(
                Pair.of(root, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)),
                Pair.of(new BinaryTreeNode<>(1), Collections.singletonList(1)),
                Pair.of(new BinaryTreeNode<>(1, null, new BinaryTreeNode<>(2)), Arrays.asList(1, 2)),
                Pair.of(new BinaryTreeNode<>(1, new BinaryTreeNode<>(2), null), Arrays.asList(1, 2)),
                Pair.of(null, Collections.emptyList())
        );
    }

}
