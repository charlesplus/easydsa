package dsa.testcase;

import dsa.ds.ListNode;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class ListNodeReverseTestCaseSet implements TestCaseSet<ListNode<Integer>, ListNode<Integer>> {
    @Getter
    public static final ListNodeReverseTestCaseSet instance = new ListNodeReverseTestCaseSet();
    private ListNodeReverseTestCaseSet() {
    }

    @Override
    public List<Pair<ListNode<Integer>, ListNode<Integer>>> getTestCases() {
        // 单节点测试: [1] -> [1]
        ListNode<Integer> singleNode1 = new ListNode<>(1);
        ListNode<Integer> expectedSingle = new ListNode<>(1);

        // 两节点测试: [1,2] -> [2,1]
        ListNode<Integer> node2Input = new ListNode<>(2);
        ListNode<Integer> node1Input = new ListNode<>(1, node2Input);  // 1->2
        ListNode<Integer> node1Expected = new ListNode<>(1);
        ListNode<Integer> node2Expected = new ListNode<>(2, node1Expected);  // 2->1

        // 三节点测试: [1,2,3] -> [3,2,1]
        ListNode<Integer> node3Input = new ListNode<>(3);
        ListNode<Integer> node2InputNext = new ListNode<>(2, node3Input);  // 2->3
        ListNode<Integer> node1InputNext = new ListNode<>(1, node2InputNext);  // 1->2->3
        ListNode<Integer> node1ExpectedFinal = new ListNode<>(1);
        ListNode<Integer> node2ExpectedFinal = new ListNode<>(2, node1ExpectedFinal);  // 2->1
        ListNode<Integer> node3ExpectedFinal = new ListNode<>(3, node2ExpectedFinal);  // 3->2->1

        return Arrays.asList(
            Pair.of(singleNode1, expectedSingle),
            Pair.of(node1Input, node2Expected),
            Pair.of(node1InputNext, node3ExpectedFinal)
        );
    }
}