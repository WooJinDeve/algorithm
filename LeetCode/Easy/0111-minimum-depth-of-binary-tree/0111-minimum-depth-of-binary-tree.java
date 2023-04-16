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
import java.util.*;

class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<NodeLevel> q = new LinkedList<>();
        q.add(new NodeLevel(root));
        int min = Integer.MAX_VALUE;
        
        while(!q.isEmpty()){
            NodeLevel nl = q.remove();
            if(nl.t.left == null && nl.t.right == null){
                min = Math.min(min, nl.level + 1);
                continue;
            }
            if(nl.t.left != null) q.add(new NodeLevel(nl.t.left, nl.level + 1));
            if(nl.t.right != null) q.add(new NodeLevel(nl.t.right, nl.level + 1));
        }
        
        return min;
    }
    
    private class NodeLevel{
        private TreeNode t;
        private int level;
        
        public NodeLevel(TreeNode t){
            this.t = t;
            this.level = 0;
        }
        
        public NodeLevel(TreeNode t, int level){
            this.t = t;
            this.level = level;
        }
    }
}