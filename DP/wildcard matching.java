//recursion
TC : exponential
SC : O(n*m)

boolean solve(int ind1,int ind2,String s, String p){
        if(ind1<0 && ind2< 0) return true;
        if(ind2<0 && ind1>=0) return false;
        if(ind1<0 && ind2>=0) {
            for(int i=0;i<=ind2;i++){
                if(p.charAt(i)!='*')
                    return false;
            }
            return true;
        }
        if(s.charAt(ind1)==p.charAt(ind2) || p.charAt(ind2)=='?'){
            return solve(ind1-1,ind2-1,s,p);
        }

        else if(p.charAt(ind2) == '*'){
            return solve(ind1-1,ind2,s,p) || solve(ind1,ind2-1,s,p);
        }
        else
        return false;
    }
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        return solve(m-1,n-1,s,p);
    }
