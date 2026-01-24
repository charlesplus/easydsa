package dsa.solution.tree;

import dsa.annotation.RunSolution;
import dsa.solution.Solution;
import dsa.testcase.BinaryTreeDfsTestCaseSet;
import dsa.testcase.TestCaseSet;
import dsa.ds.BinaryTreeNode;

import java.util.*;

@RunSolution(runByDefault = true)
public class BinaryTreeDfsSolution implements Solution<BinaryTreeNode<Integer>, List<Integer>> {

    @Override
    public List<Integer> solve(BinaryTreeNode<Integer> input) {
        // dfs  iteration (non-recursive)
//        if (input == null) {
//            return Collections.emptyList();
//        }
//        List<Integer> result = new ArrayList<>();
//        Deque<BinaryTreeNode<Integer>> stack = new LinkedList<>();
//        stack.push(input);
//        while (!stack.isEmpty()) {
//            BinaryTreeNode<Integer> node = stack.pop();
//            result.add(node.getValue());
//            // push right first to visit left first
//            if (node.getRight() != null) {
//                stack.push(node.getRight());
//            }
//            if (node.getLeft() != null) {
//                stack.push(node.getLeft());
//            }
//        }

        // dfs recursive
        List<Integer> result = new ArrayList<>();
        dfs(input, result);
        return result;
    }
    private void dfs(BinaryTreeNode<Integer> node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.getValue());
        dfs(node.getLeft(), result);
        dfs(node.getRight(), result);
    }

    @Override
    public TestCaseSet<BinaryTreeNode<Integer>, List<Integer>> getTestCaseSet() {
        return BinaryTreeDfsTestCaseSet.getInstance();
    }
}
