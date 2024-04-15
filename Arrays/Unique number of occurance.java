Given an array arr of N integers, the task is to check whether the frequency of the elements in the array is unique or not. Or in other words, 
  there are no two distinct numbers in array with equal frequency. If all the frequency is unique then return true, else return false.

public static boolean isFrequencyUnique(int n, int[] arr) {
        // code here
        HashMap<Integer,Integer> mp = new HashMap<>();
        
        for(int i=0;i<n;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i], 0) +1);
        }
        
        HashSet<Integer> uniqueFreq = new HashSet<Integer>();
 
   
        for (Integer num : mp.keySet())  
        {
            int cnt = mp.get(num);
            if (uniqueFreq.contains(cnt))
                return false;
            else
                uniqueFreq.add(cnt);
        }
        return true;
    }
