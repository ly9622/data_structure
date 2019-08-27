package com.learn.tree;

import java.util.LinkedList;
import java.util.Queue;
import lombok.AllArgsConstructor;

public class AvlTreeLearn {

    private TreeNode root;

    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val, null, null, 0);
            return;
        }
        root = do_insert(root, val);
    }

    private TreeNode do_insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val, null, null, 0);
        }
        if (val <= node.val) {
            node.left = do_insert(node.left, val);
            if (calHeight(node) == 2) {
                if (val < node.left.val) {
                    node = rightRotation(node);
                } else {
                    node.left = leftRotation(node.left);
                    node = rightRotation(node);
                }
            }
        } else {
            node.right = do_insert(node.right, val);
            if (calHeight(node) == 2) {
                if (val > node.left.val) {
                    node = leftRotation(node);
                } else {
                    node.right = rightRotation(node.left);
                    node = leftRotation(node);
                }
            }
        }
        node.height = calHeight(node);
        return node;
    }

    /**
     * 右旋操作
     *
     * @param node
     * @return
     */
    private TreeNode rightRotation(TreeNode node) {
        TreeNode bNode = node.left;
        node.left = bNode.right;
        bNode.right = node;

        bNode.height = calHeight(bNode);
        node.height = calHeight(node);

        return bNode;
    }

    /**
     * 左旋操作
     *
     * @param node
     * @return
     */
    private TreeNode leftRotation(TreeNode node) {
        TreeNode bNode = node.right;
        node.right = bNode.left;
        bNode.left = node;

        bNode.height = calHeight(bNode);
        node.height = calHeight(node);

        return bNode;
    }

    /**
     * 计算节点高度
     *
     * @param node
     * @return
     */
    private static int calHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 0;
        }
        return 1 + Math.max(calHeight(node.left), calHeight(node.right));
    }

    private static void sort4(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode a = queue.poll();
            System.out.println(a.toString());
            if (a.left != null) {
                queue.add(a.left);
            }
            if (a.right != null) {
                queue.add(a.right);
            }
        }
        System.out.println("==============");
    }

    public static void main(String[] args) {
        AvlTreeLearn treeLearn = new AvlTreeLearn();
        treeLearn.insert(3);
        treeLearn.insert(2);
        treeLearn.insert(1);
        sort4(treeLearn.root);
    }

    @AllArgsConstructor
    static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;
        /**
         * 定义节点高度，高度指当前点到叶子节点的最大距离，叶子节点的高度为0
         */
        public int height;

        @Override
        public String toString() {
            return this.val + ",height:" + height;
        }
    }
}
