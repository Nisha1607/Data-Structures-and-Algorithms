  static class Trie{
        Trie[] links= new Trie[26];
        int freq=0;
        
        Trie(){
            freq=0;
            links= new Trie[26];
        }
    }
    
    static String[] findPrefixes(String[] arr, int N) {
        // code here
         Trie root = new Trie();
        for(String str : arr){
            Trie node = root;
            for(char ch : str.toCharArray()){
                if(node.links[ch-'a']==null){
                    node.links[ch-'a'] = new Trie();
                }
               node.freq++;
               node = node.links[ch-'a'];
            }
        }
        
        ArrayList<String> res= new ArrayList<>();
        
        for(String str : arr){
            Trie node = root;
            int i=0;
            char[] charArray = new char[str.length()];
            for(char ch : str.toCharArray()){
                if(node.freq==1){
                   break;
                }
                charArray[i++]=ch;
                node = node.links[ch-'a'];
            }
            res.add(String.valueOf(charArray));
        }
        String[] ans = new String[N];
        int k=0;
        for(String str : res){
            ans[k++]=str;
        }
        
        return ans;
        
    }
