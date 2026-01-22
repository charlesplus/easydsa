package dsa.testcase;

import dsa.ds.ListNode;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class ListNodePartialReverseTestCaseSet implements TestCaseSet<Pair<ListNode<Integer>, Pair<Integer, Integer>>, ListNode<Integer>> {
    @Getter
    public static final ListNodePartialReverseTestCaseSet instance = new ListNodePartialReverseTestCaseSet();
    private ListNodePartialReverseTestCaseSet() {
    }

    @Override
    public List<Pair<Pair<ListNode<Integer>, Pair<Integer, Integer>>, ListNode<Integer>>> getTestCases() {
        return Arrays.asList(
            // 单节点链表，反转位置[0,0] -> [1]
            Pair.of(
                Pair.of(new ListNode<>(1), Pair.of(0, 0)),
                new ListNode<>(1)
            ),
            // 两节点链表，反转位置[0,1] -> [2,1]
            Pair.of(
                Pair.of(new ListNode<>(1, new ListNode<>(2)), Pair.of(0, 1)),
                new ListNode<>(2, new ListNode<>(1))
            ),
            // 两节点链表，只反转位置[1,1] -> [1,2] (无变化)
            Pair.of(
                Pair.of(new ListNode<>(1, new ListNode<>(2)), Pair.of(1, 1)),
                new ListNode<>(1, new ListNode<>(2))
            ),
            // 三节点链表，反转位置[0,2] -> [3,2,1,4] (如果原链表是1,2,3,4的话)
            // 实际上是 [1,2,3] 反转 [0,2] -> [3,2,1]
            Pair.of(
                Pair.of(new ListNode<>(1, new ListNode<>(2, new ListNode<>(3))), Pair.of(0, 2)),
                new ListNode<>(3, new ListNode<>(2, new ListNode<>(1)))
            )
        );
    }
}
