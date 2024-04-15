   public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalList=new ArrayList<>();
        List<Integer> dList = new ArrayList<>();
    

        int n=numRows;
       for(int i=0;i<n;i++){
            dList.add(0,1);
            for(int j=1;j<i;j++){
                dList.set(j,dList.get(j)+dList.get(j+1));
            }
              
            dList.set(i,1);          
            pascalList.add(new ArrayList<>(dList));
        }
        
        return pascalList;
    }
