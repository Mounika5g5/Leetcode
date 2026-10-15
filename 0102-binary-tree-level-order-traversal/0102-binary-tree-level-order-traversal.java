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
        List<List<Integer>> list = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return list;
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> inner = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode popped = q.poll();
                inner.add(popped.val);
                if(popped.left!=null){
                    q.offer(popped.left);
                }
                if(popped.right!=null){
                    q.offer(popped.right);
                }
            }
            list.add(inner);   
        }
        return list;
        
    }
}