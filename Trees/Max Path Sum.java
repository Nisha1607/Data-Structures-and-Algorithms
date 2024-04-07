int solve(TreeNode root,int[] maxSum){
  if(root==null) return 0;
   int left = Math.max(0,solve(root.left,maxSum));
   int right = Math.max(0,solve(root.right,maxSum));

    maxSum[0] = Math.max(maxSum,left+right+root.val);

  return root.val+ Math.max(left,right);
}
  

public int maxPathSum(TreeNode root) {
   int[] maxSum = new int[1];
   solve(root,maxSum);
   return maxSum[0];
}
