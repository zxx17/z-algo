package com.zhuo.entity;

/**
 * @author Xinxuan Zhuo
 * @version 2023/11/30
 * <p>
 *
 * </p>
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
