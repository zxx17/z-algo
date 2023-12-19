package com.zhuo.base;

import com.zhuo.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Xinxuan Zhuo
 * @version 2023/12/19
 * <p>
 *
 * </p>
 */

public class TestOfTree {

    /**
     * BASE AAAAAAAAAAAA
     * 彩灯装饰记录 I
     * 一棵圣诞树记作根节点为 root 的二叉树，节点值为该位置装饰彩灯的颜色编号。请按照从 左 到 右 的顺序返回每一层彩灯编号。
     * 输入：root = [8,17,21,18,null,null,6]
     * 输出：[8,17,21,18,6]
     */
    // BFS
    public int[] decorateRecord1(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>() {
            {
                add(root);
            }
        };
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }


    /**
     * 输入：root = [8,17,21,18,null,null,6]
     * 输出：[[8],[17,21],[18,6]]
     */
    public List<List<Integer>> decorateRecord2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
        }

        return result;
    }


}
