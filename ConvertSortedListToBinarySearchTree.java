package leetcode;

import dataStructure.ListNode;
import dataStructure.TreeNode;

public class ConvertSortedListToBinarySearchTree {

	
	// method 1: TLE solution, top-down divide and conquer, time O(nlogn), space O(nlogn)
	
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return sortedListToBST(head, 0, getListLength(head) - 1);
    }
    
    private TreeNode sortedListToBST(ListNode head, int start, int end){
        if (start > end) return null;
        
        int mid = (start + end) / 2;
        int val = getListVal(head, mid);
        TreeNode node = new TreeNode(val);
        node.left = sortedListToBST(head, start, mid - 1);
        node.right = sortedListToBST(head, mid + 1, end);
        return node;
    }
    
    private int getListVal(ListNode head, int pos){
        ListNode node = head;
        for (int i = 0; i < pos; i++){
            node = node.next;
        }
        return node.val;
    }
    
    private int getListLength(ListNode head){
        int cnt = 0;
        ListNode node = head;
        while (node != null){
            node = node.next;
            cnt++;
        }
        return cnt;
    }
    
    
    // method 2: convert linked list to array
    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null) return null;
        int size = 0;
        ListNode tmp = head;
        while (tmp != null){
            tmp = tmp.next;
            size++;
        }
        
        int[] arr = new int[size];
        
        int i = 0;
        while (head != null){
            arr[i] = head.val;
            head = head.next;
            i++;
        }
        
        return arrToBST(arr, 0, size - 1);
    }
    
    private TreeNode arrToBST(int[] arr, int start, int end){
        if (start > end) return null;
        
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = arrToBST(arr, start, mid - 1);
        node.right = arrToBST(arr, mid + 1, end);
        return node;
    }
    
    
    // method 3: bottom-up, in order traversal, time O(n), space O(logn)
    private ListNode curr;
    
    public TreeNode sortedListToBST3(ListNode head) {
        int size = 0;
        ListNode tmp = head;
        while (tmp != null){
            tmp = tmp.next;
            size++;
        }
        
        curr = head;
        return sortedListToBSTHelper(size);
    }
    
    private TreeNode sortedListToBSTHelper(int size){
        if (size <= 0) return null;
        
        TreeNode node = new TreeNode(0);
        node.left = sortedListToBSTHelper(size /2);
        node.val = curr.val;
        curr = curr.next;
        node.right = sortedListToBSTHelper(size - size /2 - 1);
        return node;
    }
    
    
    // method 4: another bottom-up, very similar to method 3, time O(n), space O(logn)
    ListNode list;
    public TreeNode sortedListToBST4(ListNode head) {
        int size = 0;
        ListNode tmp = head;
        while (tmp != null){
            tmp = tmp.next;
            size++;
        }
        
        list = head;
        return sortedListToBSTRec(0, size - 1);
    }
    
    private TreeNode sortedListToBSTRec(int start, int end){
        if (start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode leftChild = sortedListToBSTRec(start, mid - 1);
        TreeNode parent = new TreeNode(list.val);
        parent.left = leftChild;
        list = list.next;
        parent.right = sortedListToBSTRec(mid + 1, end);
        
        return parent;
    }
    
    
}
