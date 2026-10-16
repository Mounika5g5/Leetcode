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
    class NodeInfo{
        TreeNode node;
        int col;
        int row;
        NodeInfo(TreeNode node, int col, int row){
            this.node=node;
            this.col=col;
            this.row=row;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        if(root==null) return new ArrayList<>();

        Queue<NodeInfo> q = new LinkedList<>();
        q.offer(new NodeInfo(root,0,0));
        TreeMap<
               Integer,
               TreeMap<Integer,PriorityQueue<Integer>>
               > map = new TreeMap<>();

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                NodeInfo cur= q.poll();

                map.computeIfAbsent(cur.col,k -> new TreeMap<>() )
                   .computeIfAbsent(cur.row,k -> new PriorityQueue<>())
                   .offer(cur.node.val);
                
                if(cur.node.left!=null){
                    q.offer(new NodeInfo(cur.node.left,(cur.col)-1,(cur.row)+1));
                }
                if(cur.node.right!=null){
                    q.offer(new NodeInfo(cur.node.right,(cur.col)+1,(cur.row)+1));
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer,PriorityQueue<Integer>> rows:map.values()){
            List<Integer> inner= new ArrayList<>();
            for(PriorityQueue<Integer> pq : rows.values()){
                while(!pq.isEmpty()){
                    inner.add(pq.poll());

                }
            }
            ans.add(inner);
        }
        return ans;
        

        
    }
}