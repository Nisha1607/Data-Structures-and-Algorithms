 Pair<Integer,Integer> dfs(TreeNode root,int[] cnt){
         if(root==null)
            return new Pair<>(0,0);
        Pair<Integer,Integer> left = dfs(root.left,cnt);
        Pair<Integer,Integer> right = dfs(root.right,cnt);
        
        int nodeSum = root.val + left.getKey() + right.getKey();
        int nodeCount = 1 + left.getValue() + right.getValue();

        if(root.val == nodeSum/nodeCount)
            cnt[0]++;

        return new Pair<>(nodeSum,nodeCount);
    }
    public int averageOfSubtree(TreeNode root) {
       int[] cnt=new int[1];
       dfs(root,cnt);
       return cnt[0];
    }
