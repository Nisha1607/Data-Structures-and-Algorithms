each node contains 26 size array which can contains a-z letters and a boolean flg which initially set to false and only set in thereference node of last char of the word to inidicate end of the word
whenever we want to insert a word, we check character by character from root if laready exists or not , if it exists we go toits ref node and check for second letter and so on
  if it does not contain we add that letter and at the end of the word we set flg as true


class Node{
  Node links[] = new Node[26];
  boolean flg = false;

  Node(){}

  boolean containsKey(char ch){
    return (links[ch-'a']!=null)
  }

  Node get(char ch){
    return links[ch-'a'];
  }

  void put(char ch,Node node){
    links[ch-'a'] = node;
  }

  boolean isEnd(){
    return flg;
  }

  void setEnd(){
    flg=true;
  }
}

class Trie{
    Node root;
    Trie(){
      root = new Node();
    }

    void insertWord(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
          if(!node.containsKey(word.charAt(i))){
              node.put(word.charAt(i),new Node());
          }
          node = node.get(word.charAt(i));
        }
      node.setEnd();
    }

    boolean searchWord(String word){
        Node node = root;
         for(int i=0;i<word.length();i++){
          if(!node.containsKey(word.charAt(i))){
              return false;
          }
          node = node.get(word.charAt(i));
        }
      if(node.isEnd) return true;
      return false;
    }

     boolean startsWith(String word){
        Node node = root;
         for(int i=0;i<word.length();i++){
          if(!node.containsKey(word.charAt(i))){
              return false;
          }
          node = node.get(word.charAt(i));
        }
     return true;
    }
