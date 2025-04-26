public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        StringBuilder str = new StringBuilder();
        while(!que.isEmpty()){
            TreeNode node = que.poll(); 
            if(node==null){
                str.append("#,");
                continue;
            }
            str.append(node.val+ ",");
            que.add(node.left);
            que.add(node.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        int n = data.length();  
        String[] str = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        for(int i=1;i<str.length;i++){
            TreeNode parent = que.poll();
           if(!str[i].equals("#")){
                TreeNode left=new TreeNode(Integer.parseInt(str[i]));
                parent.left=left;
                que.add(left);
           }
            if(!str[++i].equals("#")){
                TreeNode right=new TreeNode(Integer.parseInt(str[i]));
                parent.right=right;
                que.add(right);
            }
        }
        return root;
    }
}
