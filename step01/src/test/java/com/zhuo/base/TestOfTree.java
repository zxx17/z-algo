package com.zhuo.base;

import com.zhuo.entity.TreeNode;
import org.junit.Test;

import java.util.*;

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

    /**
     * AAAAAAAAAAAAAAA
     * 一棵圣诞树记作根节点为 root 的二叉树，节点值为该位置装饰彩灯的颜色编号。请按照如下规则记录彩灯装饰结果：
     *
     * 第一层按照从左到右的顺序记录
     * 除第一层外每一层的记录顺序均与上一层相反。即第一层为从左到右，第二层为从右到左。
     *
     * 输入：root = [8,17,21,18,null,null,6]
     * 输出：[[8],[21,17],[18,6]]
     */
    public List<List<Integer>> decorateRecord3(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> result  = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int flag =0;

        while(!queue.isEmpty()){
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
            if (flag %2 != 0){
                level = reverse(level);
            }
            result.add(level);
            flag++;
        }
        return result;
    }
    //两极反转
    public List<Integer> reverse(List<Integer> level){
        Collections.reverse(level);
        return level;
    }



//    @Test
//    public void testDecorateRecord(){
//        TreeNode root = new TreeNode(8);
//        TreeNode node1 = new TreeNode(17);
//        TreeNode node2 = new TreeNode(21);
//        TreeNode node3 = new TreeNode(18);
//        TreeNode node4 = new TreeNode(6);
//
//        root.left = node1;
//        root.right = node2;
//        node1.left = node3;
//        node2.left = node4;
//        decorateRecord3(root);
//    }


    /**
     * 子结构判断
     * 给定两棵二叉树 tree1 和 tree2，判断 tree2 是否以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
     * 注意，空树 不会是以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
     *
     * 输入：tree1 = [1,7,5], tree2 = [6,1]
     * 输出：false
     * 解释：tree2 与 tree1 的一个子树没有相同的结构和节点值。
     *
     * 输入：tree1 = [3,6,7,1,8], tree2 = [6,1]
     * 输出：true
     * 解释：tree2 与 tree1 的一个子树拥有相同的结构和节点值。即 6 - > 1。
     *
     */
    // 题解 https://leetcode.cn/leetbook/read/illustration-of-algorithm/lhb1ps/
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

}
