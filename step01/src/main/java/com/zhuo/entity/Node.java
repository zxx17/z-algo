package com.zhuo.entity;

/**
 * @author Xinxuan Zhuo
 * @version 2023/12/3
 * <p>
 *
 * </p>
 */

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
