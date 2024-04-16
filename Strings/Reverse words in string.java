
//TC : O(N)
//SC : O(N)
public String reverseWords(String s) {
        Stack<String> stk = new Stack<String>();
        String val="";
        for(int i=0;i<s.length();i++){
            if(i==s.length()-1&&s.charAt(i)!=' '){
                stk.add(val+s.charAt(i));
            }
             if(i==s.length()-1&&s.charAt(i)==' '&&val!=""){
                stk.add(val);
            }
          else if(( s.charAt(i)==' ')&&!val.equals("")){
                stk.add(val);
                val="";
            }
            else if(s.charAt(i)!=' '){
                val+=s.charAt(i);
            }
         
        }
        String res=new String();
        while(!stk.isEmpty()){
            res+=stk.pop();
            if(!stk.isEmpty())
            res+=" ";
       //     stk.pop();

        }
        return res;
    }


 public String reverseWords(String s) {
       String[] words = s.trim().split("\\s+");
       StringBuilder result = new StringBuilder();

       for(int i=words.length - 1 ; i>0 ; i--){
        result.append(words[i]).append(" ");
       }

       return result.append(words[0]).toString();
    }
