

// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    
    boolean isLeaf(Node node){
        if(node.left==null && node.right==null)
            return true;
        return false;
    }
    
    void leftBoundry(Node node, ArrayList<Integer> res){
        Node curr = node.left;
        while(curr!=null){
            if(!isLeaf(curr))
                res.add(curr.data);
            if(curr.left!=null)
                curr=curr.left;
            else
                curr=curr.right;
            
        }
    }
    
    void rightBoundry(Node node, ArrayList<Integer> res){
        Node curr = node.right;
        Stack<Integer> stk = new Stack<>();
        while(curr!=null){
            if(!isLeaf(curr))
                stk.push(curr.data);
            if(curr.right!=null)
                curr=curr.right;
            else
                curr=curr.left;
        }
        while(!stk.isEmpty()){
            res.add(stk.pop());
        }
    }
    
    void addLeaves(Node node, ArrayList<Integer> res){
        if(isLeaf(node)) {
            res.add(node.data);
            return;
        }
        if(node.left!=null)
            addLeaves(node.left,res); 
        if(node.right!=null)
            addLeaves(node.right,res);
        
    }
    
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> res= new ArrayList<>();
        if(!isLeaf(node)){
            res.add(node.data);
        }
        leftBoundry(node,res);
        addLeaves(node,res);
        rightBoundry(node,res);
        return res;
    }
}
