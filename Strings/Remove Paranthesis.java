//TC : O(N)
// SC : O(N)

    public String removeOuterParentheses(String s) {
        Stack<Character> stk = new Stack<>();
        String res=new String();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(stk.size()>0)
                    res += s.charAt(i);
                stk.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
              if(stk.size()>1)
                res+=s.charAt(i);
              stk.pop();  
            }
        }
        return res;
    }

//TC : O(N)
// SC : O(1)

  public String removeOuterParentheses(String s) {
        int openParanthesis=0;
        String res=new String();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(openParanthesis>0)
                    res += s.charAt(i);
               openParanthesis++;
            }
            else if(s.charAt(i)==')'){
              if(openParanthesis>1)
                res+=s.charAt(i);
              openParanthesis--; 
            }
        }
        return res;
    }
