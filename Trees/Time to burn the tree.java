
//https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/

    TreeNode markParents(TreeNode root, Map<TreeNode,TreeNode> map, int start){
        Queue<TreeNode> que = new LinkedList<>(); 
        que.add(root);
        TreeNode target=null;
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            int n = que.size();
            if(node.val==start){
                target=node;
            }
            if(node.left!=null){
                que.add(node.left);
                map.put(node.left,node);
            } 
            if(node.right!=null){
                que.add(node.right);
                map.put(node.right,node);
            }  
        }
        return target;
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        TreeNode target = markParents(root,parentMap,start);
        Queue<TreeNode> que = new LinkedList<>();
        que.add(target);
        int ans=0;
        Map<TreeNode,Boolean> visited = new HashMap<>();
        visited.put(target,true);
        while(!que.isEmpty()){  
            int flg=0;
            int size=que.size();
            for(int i=0;i<size;i++){
            TreeNode node = que.poll();
            if(node.left!=null && visited.get(node.left)==null){
                flg=1;
                que.add(node.left);
                visited.put(node.left,true);
            }
            if(node.right!=null&& visited.get(node.right)==null){
                flg=1;
                que.add(node.right);
                visited.put(node.right,true);
            }
            if(parentMap.get(node)!=null&& visited.get(parentMap.get(node))==null){
                flg=1;
                que.add(parentMap.get(node));
                visited.put(parentMap.get(node),true);
            }
            }
            if(flg==1)
                ans++;
        }
        return ans;
    }
