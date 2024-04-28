//TC : O(n*m)
public int repeatedStringMatch(String a, String b) {
        int cnt=1;
        String s = a;
        while(s.length() < b.length()){
            s+=a;
            cnt++;
        }
        if(s.contains(b))
            return cnt;
        s+=a;
        cnt++;
        if(s.contains(b))
            return cnt;
        return -1;
    }
