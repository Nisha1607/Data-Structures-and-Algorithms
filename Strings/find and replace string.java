S = "gforks"
Q = 2
index[] = {0, 4}
sources[] = {"g", "ks"}
targets[] = {"geeks", "geeks"}
Output: 
geeksforgeeks



static String findAndReplace(String S, int Q, int[] index, String[] sources, String[] targets) {
        // code here\
        String res = "";
        int space = 0;
            for(int j=0;j<Q;j++){
                res+=S.substring(res.length()-space,index[j]);
                int len = sources[j].length();
                if(sources[j].equals(S.substring(index[j],index[j]+len))){
                    space += targets[j].length()-sources[j].length();
                    res+=targets[j];
                }
            }
            
            res+=S.substring(res.length()-space);
        
        return res;
    }
