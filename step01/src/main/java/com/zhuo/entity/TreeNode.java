package com.zhuo.entity;

/**
 * @author Xinxuan Zhuo
 * @version 2023/12/19
 * <p>
 * Definition for a binary tree node.
 * </p>
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
