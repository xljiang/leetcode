package leetcode;

import dataStructure.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        //if (root == null) return;
        TreeNode curr = root;
        while (curr != null){
            if (curr.left != null){
                TreeNode tmp = curr.right;
                TreeNode node = curr.left;
                curr.right = node;
                while (node.right != null){
                    node = node.right;
                }
                node.right = tmp;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
