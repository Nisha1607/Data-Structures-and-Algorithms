//https://leetcode.com/problems/reorganize-string/description/?envType=problem-list-v2&envId=7p5x763

class Solution {
    public String reorganizeString(String s) {
        int[] hash = new int[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
        }
         int max = 0, letter = 0;
        for(int i=0;i<hash.length;i++){
            if(hash[i]>max){
                max=hash[i];
                letter=i;
            }
        }
        if(max>(s.length()+1)/2) return "";
        int idx=0;
        char[] res=new char[s.length()];
        while(hash[letter]>0){
            res[idx]=(char)(letter+'a');
            idx+=2;
            hash[letter]--;
        }
        for(int i=0;i<hash.length;i++){
            while(hash[i]>0){
                if(idx >= res.length){
                    idx=1;
                }
                res[idx]+=(char)(i+'a');
                idx+=2;
                hash[i]--;
            }
        }
        return String.valueOf(res);

    }
}
