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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queuep = new LinkedList();
        Queue<TreeNode> queueq  = new LinkedList();

        queuep.add(p);
        queueq.add(q);

        while(!queuep.isEmpty() && !queueq.isEmpty()){
            TreeNode nodep = queuep.remove();
            TreeNode nodeq = queueq.remove();

            if(nodep == null && nodeq == null){
                continue;
            }
            if(nodep != null && nodeq != null){
                if(nodep.val != nodeq.val) return false;
                queuep.add(nodep.left);
                queuep.add(nodep.right);
                queueq.add(nodeq.left);
                queueq.add(nodeq.right);
            }
            else{
                return false;
            }
            
            
        }
        if(queueq.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}