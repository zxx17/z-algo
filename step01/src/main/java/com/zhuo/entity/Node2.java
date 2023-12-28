package com.zhuo.entity;

/**
 * @author Xinxuan Zhuo
 * @version 2023/12/28
 * <p>
 *
 * </p>
 */

public class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val,Node2 _left,Node2 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
