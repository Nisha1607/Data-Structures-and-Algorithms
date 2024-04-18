



//bruteforce
static String ReFormatString(String S, int K){
        // code here
        String res="";
        int cnt=0;
        for(int i=S.length()-1;i>=0;i--){
            if(S.charAt(i)>='A' && S.charAt(i)<='Z'|| S.charAt(i)>='a' && S.charAt(i)<='z' || S.charAt(i)>='0' && S.charAt(i)<='9'){
                cnt++;
                res+=S.charAt(i);
            }
            if(cnt==K && i!=0 && S.charAt(i-1)!='-'){
                res+="-";
                cnt=0;
            }
        }
          StringBuffer sbr = new StringBuffer(res);
        // To reverse the string
        res = sbr.reverse().toString();
        return res.toUpperCase();
    }



//efficient
  static String ReFormatString(String s, int k){
       
        s = s.replaceAll("-", "").toUpperCase();
        int grpLen = s.length()%k;
        
        StringBuilder sb = new StringBuilder();
        
        if(grpLen > 0)
        {
            sb.append(s.substring(0,grpLen));
            sb.append("-");
        }
        
        for(int i=grpLen;i<s.length();i+=k)
        {
            sb.append(s.substring(i,i+k));
            sb.append("-");
        }
        
        if(sb.length()>0 && sb.charAt(sb.length()-1)=='-')
            sb.deleteCharAt(sb.length()-1);
            
        return sb.toString();
    }
