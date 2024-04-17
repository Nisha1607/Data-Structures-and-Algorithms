Given a string S. In one operation, you can remove the substring "pr" from the string S and get amount X or you can remove the substring "rp" and get the amount Y. 
Find the maximum amount you can get if you perform zero or more such operations optimally. 


  Intution - Run if X>Y and Y>X separately
            for X>Y (pr) : insert all !p elements to resultant string if we found r check for it's prev char in ans String if it is p then add X to res
            vice versa for Y>X
            At the end we might have missed on rp elements in X>Y and pr in Y>X case so call alternte method at the end.



  //TC / SC : O(N)
static long solveXY(int X,int Y, String S,boolean flg){
        int n = S.length();
        StringBuilder ans = new StringBuilder();
        long res=0;
        for(int i=0;i<n;i++){
            if(S.charAt(i)=='r'){
                if(ans.length()>0&&ans.charAt(ans.length()-1)=='p'){
                    res+=X;
                    ans.deleteCharAt(ans.length()-1);
                }
                else{
                    ans.append('r');
                }
            }
            else{
                ans.append(S.charAt(i));
            }
        }
        if(flg && ans.length()!=0)
            res+= solveYX(X,Y,ans.toString(),false);
        return res;
    }
    
     static long solveYX(int X,int Y, String S,boolean flg){
        int n = S.length();
        StringBuilder ans = new StringBuilder();
        long res=0;
        for(int i=0;i<n;i++){
            if(S.charAt(i)=='p'){
                if(ans.length()>0&&ans.charAt(ans.length()-1)=='r'){
                    res+=Y;
                    ans.deleteCharAt(ans.length()-1);
                }
                else{
                    ans.append('p');
                }
            }
            else{
                ans.append(S.charAt(i));
            }
        }
        if(flg && ans.length()!=0)
            res+= solveXY(X,Y,ans.toString(),false);
        return res;
    }
    
    static long solve(int X,int Y, String S)
	{    
	    // code here
	    if(X>Y){
	      return solveXY(X,Y,S,true);
	    }
	    else{
	       return solveYX(X,Y,S,true);
	    }
	    
	}
