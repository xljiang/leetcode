package leetcode;

import dataStructure.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postIdx){
        if (postIdx < 0 || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIdx]);
        
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++){
            if (inorder[i] == root.val)
                inIndex = i;
        }
        
        root.left = helper(inorder, postorder, inStart, inIndex - 1, postIdx - (inEnd - inIndex) - 1);
        root.right = helper(inorder, postorder, inIndex + 1, inEnd, postIdx - 1);
        return root;
    }
}
