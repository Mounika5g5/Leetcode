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
    static class NodeInfo{
        TreeNode node;
        long index;
        NodeInfo(TreeNode node,long index){
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) { 
        if(root == null) return 0;

        Queue <NodeInfo> q = new LinkedList<>();
        q.offer( new NodeInfo(root,0));

        long  maxWidth=0;

        while(!q.isEmpty()){
            int size=q.size();
            long minIdx = q.peek().index;
            long frst=0;
            long last=0;

            for(int i=0;i<size;i++){

                NodeInfo info = q.poll();
                TreeNode node=info.node;
                long index=info.index - minIdx;

                if(i==0) frst = index;
                if(i==size-1) last =index;

                if(node.left!=null){
                    q.offer(new NodeInfo(node.left, 2*index+1));
                }
                 if(node.right!=null){
                    q.offer(new NodeInfo(node.right, 2*index+2));
                }

                
            }
            maxWidth = Math.max(maxWidth, last - frst +1);
            
        }
        return (int) maxWidth;   
    }
}