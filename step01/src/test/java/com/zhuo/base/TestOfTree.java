package com.zhuo.base;

import com.zhuo.entity.Node;
import com.zhuo.entity.Node2;
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
     * <p>
     * 第一层按照从左到右的顺序记录
     * 除第一层外每一层的记录顺序均与上一层相反。即第一层为从左到右，第二层为从右到左。
     * <p>
     * 输入：root = [8,17,21,18,null,null,6]
     * 输出：[[8],[21,17],[18,6]]
     */
    public List<List<Integer>> decorateRecord3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int flag = 0;

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
            if (flag % 2 != 0) {
                level = reverse(level);
            }
            result.add(level);
            flag++;
        }
        return result;
    }
    //两极反转
    public List<Integer> reverse(List<Integer> level) {
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
     * <p>
     * 输入：tree1 = [1,7,5], tree2 = [6,1]
     * 输出：false
     * 解释：tree2 与 tree1 的一个子树没有相同的结构和节点值。
     * <p>
     * 输入：tree1 = [3,6,7,1,8], tree2 = [6,1]
     * 输出：true
     * 解释：tree2 与 tree1 的一个子树拥有相同的结构和节点值。即 6 - > 1。
     */
    // 题解 https://leetcode.cn/leetbook/read/illustration-of-algorithm/lhb1ps/
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


    /**
     * 翻转二叉树
     * 给定一棵二叉树的根节点 root，请左右翻转这棵二叉树，并返回其根节点。
     * 输入：root = [5,7,9,8,3,2,4]
     * 输出：[5,9,7,4,2,3,8]
     */
    // BFS
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> container = new LinkedList<>();
        container.addLast(root);

        while (!container.isEmpty()) {
            int size = container.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = container.removeFirst();
                if (node.left != null) {
                    container.addLast(node.left);
                }
                if (node.right != null) {
                    container.addLast(node.right);
                }
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }
        }
        return root;
    }
    //递归AAAAAAAAA
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree2(root.right);
        root.right = mirrorTree2(tmp);
        return root;
    }


    /**
     * 请设计一个函数判断一棵二叉树是否 轴对称 。
     *
     *输入：root = [6,7,7,8,9,9,8]
     * 输出：true
     * 解释：从图中可看出树是轴对称的。
     * <a href="https://leetcode-cn.com/problems/symmetric-tree/">...</a> EASY
     */
    //递归
    public boolean checkSymmetricTree(TreeNode root) {
        return root == null || recur2(root.left, root.right);
    }
    public boolean recur2(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if (left == null || right==null || left.val!= right.val){
            return false;
        }
        return recur2(left.left,right.right) && recur2(left.right, right.left);
    }


    /**
     * AAAAAAAAAAA！！！！
     * 中序遍历DFS 递归
     * 将二叉搜索树转化为排序的双向链表
     */
    Node2 head, pre;
    public Node2 treeToDoublyList(Node2 root) {
        if (root == null){
            return  null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node2 node){
        if(node == null){
            return;
        }
        dfs(node.left);
        if (pre != null){
            head = pre;
        }else {
            head = node;
        }
        node.left = pre;
        pre = node;
        dfs(node.right);

    }

}
