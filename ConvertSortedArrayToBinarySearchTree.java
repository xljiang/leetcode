package leetcode;

import dataStructure.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

	// divide and conquer
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int start, int end){
        if (start > end) {
            return null;
        }
        else {
            int mid = (start + end) /2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(nums, start, mid - 1);
            root.right = sortedArrayToBST(nums, mid + 1, end);
            return root;
        }
    }
}
