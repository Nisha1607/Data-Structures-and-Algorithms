The distance between 2 binary strings is the sum of their lengths after removing the common prefix. 
For example: the common prefix of 1011000 and 1011110 is 1011 so the distance is len("000") + len("110") = 3 + 3 = 6.


class Trie{
    int[] nodes = new int[2];
    int isEnd=false;
}
int maxLen =0;
void insert(String str){
  Trie curr = root;
  for( char  c : str.toCharArray()){
    int i = c-'0';
    if(curr.nodes[i]==null) curr.child[i]= new Trie();
    curr = curr.nodes[i];
  }
  curr.isEnd=true;
}

int query(Trie root){
  if(root==null) return 0;
  int left = query(root.child[0]);
  int right = query(root.child[1]);
  if(left>0 && right>0)
    maxLen = Math.max(maxLen,left+right);
  return 1+Math.max(left,right);
}

int solve(String[] str){
  Trie root = new Trie();
  for(String word : str){
    insert(word);
  }
  query(root);
}
