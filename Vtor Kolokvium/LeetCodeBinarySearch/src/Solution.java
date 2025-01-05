import java.util.*;

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val < val) return searchBST(root.right, val);
        return searchBST(root.left, val);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if(key<root.val){
            root.left = deleteNode(root.left, key);
        }
        else if(key>root.val){
            root.right = deleteNode(root.right, key);
        }
        else{
            if(root.left == null && root.right==null){
                return null;
            }
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            TreeNode IS = findMin(root.right);
            root.val = IS.val;
            root.right= deleteNode(root.right, IS.val);

        }
        return root;

    }
    public TreeNode findMin(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}