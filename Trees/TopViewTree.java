  class Pair{
        Node node;
        int level;
        Pair(Node node,int level){
            this.node = node;
            this.level = level;
        }
    }
     ArrayList<Integer> topView(Node root)
    {
        Queue<Pair> que = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        que.add(new Pair(root,0));
        int level=0;
        while(!que.isEmpty()){
            Pair p = que.poll();
            level = p.level;
            root = p.node;
            if(!map.containsKey(level)){
                map.put(level,root.data);
            }
            if(root.left!=null)
                que.add(new Pair(root.left,level-1));
            if(root.right!=null)
                que.add(new Pair(root.right,level+1));
        }
        map.forEach((key,val)->{res.add(val);});
        return res;
    }
