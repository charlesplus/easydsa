package dsa.testcase;

import dsa.ds.BinaryTreeNode;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryTreeDfsTestCaseSet implements TestCaseSet<BinaryTreeNode<Integer>, List<Integer>> {
    //singleton
    @Getter
    private final static BinaryTreeDfsTestCaseSet instance = new BinaryTreeDfsTestCaseSet();
    private BinaryTreeDfsTestCaseSet() {
    }


    @Override
    public List<Pair<BinaryTreeNode<Integer>, List<Integer>>> getTestCases() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> left = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> right = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> leftLeft = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> leftRight = new BinaryTreeNode<>(5);
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(leftLeft);
        left.setRight(leftRight);
        return Arrays.asList(
                Pair.of(root, Arrays.asList(1, 2, 4, 5, 3)),
                Pair.of(new BinaryTreeNode<>(1), Collections.singletonList(1)),
                Pair.of(new BinaryTreeNode<>(1, null, new BinaryTreeNode<>(2)), Arrays.asList(1, 2)),
                Pair.of(new BinaryTreeNode<>(1, new BinaryTreeNode<>(2), null), Arrays.asList(1, 2)),
                Pair.of(null, Collections.emptyList())
        );
    }

}
