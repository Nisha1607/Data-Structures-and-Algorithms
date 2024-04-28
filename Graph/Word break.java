 class Trie{
        boolean isWord;
        Trie[] links;

        Trie(){
            isWord = false;
            links = new Trie[26];
        }
    }

    Trie root = new Trie();
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Trie();

       for(String it : wordDict){
            Trie node = root;

            for(char ele : it.toCharArray()){
                if(node.links[ele-'a']==null){
                    node.links[ele-'a']=new Trie();
                }

                node = node.links[ele-'a'];
            }

            node.isWord = true;
        }
          boolean[] dp = new boolean[s.length()];
        
        for(int i = 0;i < s.length();i++){
            if(i == 0|| dp[i-1]){
                Trie node = root;
                for(int j = i;j < s.length();j++){
                    char ele = s.charAt(j);

                    if(node.links[ele-'a']==null){
                        break;
                    }

                    node =node.links[ele-'a'];
                    if(node.isWord){
                        dp[j] = true;
                    }
                }
            }
        }

        return dp[s.length()-1];
    }
