package com.learn.tree;

import java.util.LinkedList;
import java.util.Queue;
import lombok.AllArgsConstructor;

/**
 * 二叉树遍历，包括先序、中序、后序、层级排序
 * <p>
 * 排序都是相对根节点的访问顺序来说的
 */
public class TreeShow {

    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4, null, null);
        TreeNode n1 = new TreeNode(1, null, n4);
        TreeNode n2 = new TreeNode(2, null, null);
        final TreeNode root = new TreeNode(3, n1, n2);

        System.out.println("===========");
        先序遍历(root);
        System.out.println("===========");
        中序遍历(root);
        System.out.println("===========");
        后序遍历(root);
        System.out.println("===========");
        层级遍历(root);
        System.out.println("===========");
    }

    /**
     * 先序遍历：先访问根节点，在访问左子树，在右子树
     *
     * @param node
     */
    private static void 先序遍历(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        先序遍历(node.left);
        先序遍历(node.right);
    }

    /**
     * 中序遍历：先访问左子树，在访问根节点，在右子树
     *
     * @param node
     */
    private static void 中序遍历(TreeNode node) {
        if (node == null) {
            return;
        }
        中序遍历(node.left);
        System.out.println(node.val);
        中序遍历(node.right);
    }

    /**
     * 后序遍历：先访问右子树，在访问左子树，在访问根节点
     *
     * @param node
     */
    private static void 后序遍历(TreeNode node) {
        if (node == null) {
            return;
        }
        后序遍历(node.left);
        后序遍历(node.right);
        System.out.println(node.val);
    }

    /**
     * 树的结构，从上到下按顺序依次输出
     *
     * @param node
     */
    private static void 层级遍历(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode a = queue.poll();
            System.out.println(a.val);
            if (a.left != null) {
                queue.add(a.left);
            }
            if (a.right != null) {
                queue.add(a.right);
            }
        }
    }


    @AllArgsConstructor
    static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;
    }

}
