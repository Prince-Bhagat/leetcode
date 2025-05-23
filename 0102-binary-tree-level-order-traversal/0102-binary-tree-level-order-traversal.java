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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return List.of();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.add(root);
        
        while (!queue.isEmpty()){
            int count = queue.size();
            System.out.print("\n");
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.remove();
                subList.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            list.add(subList);
        }
        return list;
    }
}