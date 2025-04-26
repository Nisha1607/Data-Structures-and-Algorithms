class Tuple{
    int level;
    int vertical;
    TreeNode node;
    Tuple(TreeNode node,int level,int vertical){
        this.node = node;
        this.level = level;
        this.vertical=vertical;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
      
        Queue<Tuple> que = new LinkedList<>();
        Map<Integer,Map<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        int level = 0;
        int vertical =0;
        que.add(new Tuple(root,0,0));
        while(!que.isEmpty()){
            Tuple tp = que.poll();
            level = tp.level;
            vertical = tp.vertical;
            root = tp.node;
            if (!map.containsKey(vertical)) {
                map.put(vertical, new TreeMap < > ());
            }
            if (!map.get(vertical).containsKey(level)) {
                map.get(vertical).put(level, new PriorityQueue < > ());
            }
            map.get(vertical).get(level).add(root.val);
           
        
            if(root.left!=null)
                que.add(new Tuple(root.left,level+1,vertical-1));
             if(root.right!=null)
                que.add(new Tuple(root.right,level+1,vertical+1));
        }

       List < List < Integer >> list = new ArrayList < > ();
        for (Map < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}
