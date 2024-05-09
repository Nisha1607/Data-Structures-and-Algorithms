The distance between 2 binary strings is the sum of their lengths after removing the common prefix. 
For example: the common prefix of 1011000 and 1011110 is 1011 so the distance is len("000") + len("110") = 3 + 3 = 6.



  class Trie{
    int[] nodes = new int[2];
     int isEnd=false;
}

void insert(String str){
  Trie curr = root;
  for( char  c : str.toCharArray()){
    if(curr.nodes

int solve(String[] str){
  Trie root = new Trie();
  for(String word : str){
    insert(word);
  }
  query(root);
}
