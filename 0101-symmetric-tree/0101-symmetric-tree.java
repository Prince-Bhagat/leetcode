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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.print("\nBSF ORDER : \n");
        while (!queue.isEmpty()){
            int count = queue.size();
            System.out.print("\n");
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.remove();
                list.add(node);
                if(node != null){
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            int middle = list.size()/2;
            int lastIndex = list.size() -1;
            for (int i = 0; i < middle; i++) {
                TreeNode rightNode = list.get(lastIndex - i);
                TreeNode leftNode = list.get(i);
                if(leftNode != null && rightNode != null){
                    if(leftNode.val != rightNode.val) return false;
                }else if (leftNode != rightNode ){
                    return false;
                }
            }
        }
        return true;
    }
}