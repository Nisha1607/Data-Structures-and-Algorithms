//TC : O(n*n)
//SC : O(2n)

 int celebrity(int M[][], int n)
    {
    	// code here 
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
    	
    	for(int i=0;i<n;i++){
    	    for(int j=0;j<n;j++){
    	        if(M[i][j]==1)
    	        {
    	            indegree[j]++;
    	            outdegree[i]++;
    	        }
    	    }
    	}
    	
    	for(int i=0;i<n;i++){
    	    if(indegree[i]==n-1 && outdegree[i]==0)
    	        return i;
    	}
    	
    	return -1;
    }


//Tc & SC = O(n)

  int celebrity(int M[][], int n)
    {
    	// code here 
        Stack<Integer> stk = new Stack<>();
        
        for(int i=0;i<n;i++){
            stk.push(i);
        }
        while(stk.size()!=1){
            int a = stk.pop();
            int b = stk.pop();
            
            if(M[a][b]==1)
                stk.push(b);
            else
                stk.push(a);
        }
        
        int celebrity = stk.pop();
        for(int i=0;i<n;i++){
            if(M[celebrity][i]!=0) return -1;
        }
        
        for(int i=0;i<n;i++){
            if(M[i][celebrity]!=1 && i!=celebrity) return -1;
        }
        
        return celebrity;
    }
