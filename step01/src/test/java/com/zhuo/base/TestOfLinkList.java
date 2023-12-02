package com.zhuo.base;

import com.zhuo.entity.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xinxuan Zhuo
 * @version 2023/11/30
 * <p>
 *
 * </p>
 */

public class TestOfLinkList {


    /**
     * 图书整理 I
     * 反转链表
     */
    List<Integer> reverseList = new ArrayList<>();

    public int[] reverseBookList1(ListNode head) {
        reverse(head);
        int[] result = new int[reverseList.size()];
        for (int j = 0; j < reverseList.size(); j++) {
            result[j] = reverseList.get(j);
        }
        return result;
    }

    public void reverse(ListNode head) {
        if (head == null) {
            return;
        }
        reverse(head.next);
        reverseList.add(head.val);
    }


    /**
     * 图书整理 I
     */
    public int[] reverseBookList2(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.removeLast();
        }
        return result;
    }


    /**
     * 删除链表节点
     */
    public ListNode deleteNode(ListNode head, int val) {
        // 处理头节点为目标节点的情况
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }


    /**
     * 训练计划 III
     * 反转链表
     */
    public ListNode trainningPlan1(ListNode head) {
        if (head == null) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        ListNode newHead = new ListNode(stack.removeLast());
        ListNode cur = newHead;
        while (!stack.isEmpty()) {
            ListNode node = new ListNode(stack.removeLast());
            cur.next = node;
            cur = node;
        }
        return newHead;
    }

    /**
     * 训练计划 III
     */
    public ListNode trainningPlan2(ListNode head) {
        return recur(head, null);
    }

    public ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        ListNode res = recur(cur.next, cur);
        cur.next = pre;
        return res;
    }

    /**
     * 删除链表节点
     * 训练计划 II
     */
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode fast = head, slow = head;
        for (int index = 0; index < cnt; index++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


}
