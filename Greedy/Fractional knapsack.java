double fractionalKnapsack(int w, Item arr[], int n) {
        // Your code here
        Arrays.sort(arr, new Comparator<Item>(){
            @Override
            public int compare(Item item1,Item item2){
                double cpr1 = (double) item1.value/ (double) item1.weight;
                double cpr2 = (double) item2.value/ (double) item2.weight;
                if(cpr1<cpr2)
                    return 1;
                else
                    return -1;
            }
        });
        double res=0;
        for(int i=0;i<n;i++){
            Item item = arr[i];
           
            if(item.weight<=w){
                res+=item.value;
                w-=item.weight;
            }
            else{
                if(w<=0)
                    break;
                else{
                    res+=(double)(item.value)/(double)(item.weight)*w;
                    w-=item.weight;
                }
            }
        }
        return res;
    }


//another way to write sort
  double fractionalKnapsack(int w, Item arr[], int n) {
        // Your code here
        Arrays.sort(arr, Comparator.comparing((Item a)-> (double) a.value/a.weight).reversed());
        double res=0;
        for(int i=0;i<n;i++){
            Item item = arr[i];
           
            if(item.weight<=w){
                res+=item.value;
                w-=item.weight;
            }
            else{
                if(w<=0)
                    break;
                else{
                    res+=(double)(item.value)/(double)(item.weight)*w;
                    w-=item.weight;
                }
            }
        }
        return res;
    }
