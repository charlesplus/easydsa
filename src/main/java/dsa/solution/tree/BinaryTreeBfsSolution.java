package dsa.solution.tree;

import dsa.solution.Solution;
import dsa.testcase.BinaryTreeBfsTestCaseSet;
import dsa.testcase.TestCaseSet;
import dsa.testcase.ds.BinaryTreeNode;
import lombok.Getter;

import java.util.*;

public class BinaryTreeBfsSolution implements Solution<BinaryTreeNode<Integer>, List<Integer>> {
    // singleton
    @Getter
    private static final BinaryTreeBfsSolution instance = new BinaryTreeBfsSolution();
    private BinaryTreeBfsSolution() {
    }

    @Override
    public List<Integer> solve(BinaryTreeNode<Integer> input) {
        // bfs
        if (input == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Deque<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(input);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> node = queue.poll();
            result.add(node.getValue());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return result;
    }

    @Override
    public TestCaseSet<BinaryTreeNode<Integer>, List<Integer>> getTestCaseSet() {
        return BinaryTreeBfsTestCaseSet.getInstance();
    }
}
