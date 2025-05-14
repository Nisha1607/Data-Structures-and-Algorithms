 public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        int n = s.length();
        stk.push(-1);
        int maxlen=0,len=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                stk.push(i);
            }
            else{
                stk.pop();
                if(stk.isEmpty()){
                    stk.push(i);
                }
                else{
                    maxlen=Math.max(maxlen,i-stk.peek());
                }
               
            }
            
        }
        return maxlen;
    }
