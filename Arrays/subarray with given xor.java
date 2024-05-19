 public int solve(int[] A, int k) {
        int xr=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt=0;
        map.put(xr,1);
        for(int i=0;i<n;i++){
            int xr=xr^A[i];
            int x = xr^k;
            cnt+=map.get(x);
            map.put(x,map.getOrDefault(x,0)+1);
        }
        return cnt;
    }
