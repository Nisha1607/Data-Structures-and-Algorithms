

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();

        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }

        Queue<String> q =new LinkedList<>();

        q.add(beginWord);

        int ladder = 1;

        while(!q.isEmpty()){
           
           int n = q.size();
            for(int i=0;i<n;i++){
                 System.out.println("note - "+q.peek());
                String word = q.poll();
                if(word.equals(endWord))
                    return ladder;
                for(int j=0;j<word.length();j++){
                   for(char ch='a';ch<='z';ch++){
                        char[] replacedCharArray = word.toCharArray();
                        replacedCharArray[j]=ch;
                        String replacedWord = new String(replacedCharArray);
                        if(set.contains(replacedWord)){
                            q.add(replacedWord);
                             set.remove(replacedWord);
                        }
                   }
                }
            }
            ladder++;
        }
        return 0;
    }
}
