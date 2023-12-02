package com.zhuo.base;

import com.zhuo.entity.ListNode;

import java.util.*;

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
     * 反转链表 递归
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
     * 反转链表 栈
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
     * 双指针
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
     * 反转链表 栈
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
     * 反转链表
     * 递归
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
     * 快慢指针
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


    /**
     * 合并两个有序链表
     * 循环 排序
     */
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        List<Integer> container = new ArrayList<>();
        while (l1 != null) {
            container.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            container.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(container);
        ListNode newHead = new ListNode(container.get(0));
        ListNode cur = new ListNode();
        cur = newHead;
        for (int index = 1; index < container.size(); index++) {
            ListNode node = new ListNode(container.get(index));
            cur.next = node;
            cur = node;
        }
        return newHead;
    }

    /**
     * 合并两个有序链表
     * 三指针
     */
    public ListNode trainningPlan2(ListNode l1, ListNode l2) {
        ListNode npoint = new ListNode();
        ListNode ncur = npoint;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ncur.next = l1;
                l1 = l1.next;
            } else {
                ncur.next = l2;
                l2 = l2.next;
            }
            ncur = ncur.next;
        }
        ncur.next = l2 != null ? l2 : l1;
        return npoint.next;
    }

    /**
     * 合并两个有序链表
     * 递归
     */
    public ListNode trainningPlan3(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }else if(l2 == null) {
            return l1;
        }else if(l1.val < l2.val) {
            l1.next = trainningPlan3(l1.next, l2);
            return l1;
        }else {
            l2.next = trainningPlan3(l1, l2.next);
            return l2;
        }
    }


}


