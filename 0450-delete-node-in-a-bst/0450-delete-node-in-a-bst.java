/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode findReplacer(TreeNode node) {
        TreeNode currentNode = node;
        if(node.right != null){
            node = node.right;
            if(node.left != null){
                while( node.left != null && node.left.left != null){
                    node = node.left;
                }
                TreeNode successor = node.left;
                node.left =  node.left.right;
                successor.left = currentNode.left;
                successor.right = currentNode.right;
                return successor;
            }else{
                node.left = currentNode.left;
                return node;
            }

        }else{
              if(node.left != null){
                  return node.left;
              }else{
                  return null;
              }
        }

    }
    private TreeNode searchNode(int key, TreeNode root) {
        if(root == null) return null;
        if(root.val == key) {
            TreeNode replacer = findReplacer(root);

            return replacer;
        };
        if(key < root.val){
            root.left =  searchNode(key, root.left);
        }else{
            root.right = searchNode(key, root.right);
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return searchNode(key, root);
        
    }
}