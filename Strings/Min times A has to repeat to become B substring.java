static boolean isSubstring(String S,String B){
        int m = S.length();
        int n = B.length();
        
        for(int i=0;i<=(m-n);i++){
            int j=0;
            for(;j<n;j++){
                if(S.charAt(i+j)!=B.charAt(j))
                    break;
            }
            if(j==n)
                return true;
        }
        return false;
    }
    
    static int minRepeats(String A, String B) {
        // code here
        int aSize = A.length();
        int bSize = B.length();
        
        String S =A;
        int repeat = 1;
        
        while(S.length()<B.length()){
          S+=A;
          repeat++;
        }
       
        if(isSubstring(S,B)){
            return repeat;
        }
        
        if(isSubstring(S+A,B)){
            return repeat+1;
        }
        
        return -1;
    }
