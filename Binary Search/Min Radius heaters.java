https://leetcode.com/problems/heaters/description/

public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> set = new TreeSet<>();

        for(int h : heaters){
            set.add(h);
        }
        int range=0;
        //int diff=0;
        for(int i=0;i<houses.length;i++){
            int house = houses[i];
            int ceil = set.ceiling(house)!=null ? set.ceiling(house):Integer.MAX_VALUE;
            int floor = set.floor(house)!=null ? set.floor(house) : Integer.MAX_VALUE;
            int diff= Math.min(Math.abs(ceil-house),Math.abs(house-floor));
            range = Math.max(range,diff);
        }
        return range;
    }


 public int findRadius(int[] houses, int[] heaters) {
       
        int range=0;
        Arrays.sort(heaters);
        
        for(int i=0;i<houses.length;i++){
            int house = houses[i];
            int ind = Arrays.binarySearch(heaters,house);
            if(ind<0){
                ind=-(ind+1);
            }
            int dist1 = ind-1>=0 ? house-heaters[ind-1] : Integer.MAX_VALUE;
            int dist2 = ind < heaters.length ? heaters[ind]-house : Integer.MAX_VALUE;
            range = Math.max(range,Math.min(dist1,dist2));
        }
        return range;
    }
