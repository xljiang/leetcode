package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import dataStructure.TreeNode;

public class SerializeAndDeserializeBinaryTree {

	// key word: pre-order traversal
	
	
	private static final String spliter = ",";
	private static final String NN = "#";
	
	// Encode a tree to a single string.
	public String serialize(TreeNode root){
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}
	
	private void buildString(TreeNode root, StringBuilder sb){
		if (root == null){
			sb.append(NN).append(spliter);
		} else {
			sb.append(root.val).append(spliter);
			buildString(root.left, sb);
			buildString(root.right, sb);
		}
	}
	
	// Decodes your encode data to tree.
	public TreeNode  deserialize(String data){
		Queue<String> q = new LinkedList<>();
		q.addAll(Arrays.asList(data.split(spliter)));
		return buildTree(q);
	}
	
	private TreeNode buildTree(Queue<String> q){
		String val = q.poll();
		if (val.equals("NN")) return null;
		else {
			TreeNode node = new TreeNode(Integer.parseInt(val));
			node.left = buildTree(q);
			node.right = buildTree(q);
			return node;
		}
	}
}
