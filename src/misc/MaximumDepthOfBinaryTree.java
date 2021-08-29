package src.misc;

public class MaximumDepthOfBinaryTree {

	public static void main(String[] args) {

	}


	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


    public static int maxDepth(TreeNode node) {
        if(node==null){
            return 0;
        }else{
            int left = maxDepth(node.left);
            int right = maxDepth(node.right);
            return ( Math.max(left, right) + 1 );
        }


    }


}
