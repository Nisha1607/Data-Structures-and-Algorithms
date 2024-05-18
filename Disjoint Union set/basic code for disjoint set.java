
class DisjointSet{
  List<Integer> parent = new ArrayList<>();
  List<Integer> rank = new ArrayList<>();
  List<Integer> size = new ArrayList<>();

  public DisjointSet(int n){
      for(int i=0;i<=n;i++){
          parent.add(i);
          rank.add(0);
          size.add(1);
      }
  }

  public int findUPar(int node){
    if(node == parent.get(node))
        return node;
    parent.set(node,findUPar(parent.get(node));
    return parent.get(node);
  }

  public unionByRank(int u,int v){
    int up_u = findUPar(u);
    int up_v = findUPar(v);
    if(rank[up_u] < rank[up_v])
      parent.set(up_u,up_v);
    else if(rank[up_v] < rank[up_u])
      parent.set(up_v, up_u);
    else{
      parent.set(up_u,up_v);
      rank.set(up_v,rank.get(up_v)+1);
    }
  }

   public unionByRank(int u,int v){
    int up_u = findUPar(u);
    int up_v = findUPar(v);
    if(size[up_u] < rank[up_v]){
      parent.set(up_u,up_v);
      size.set(up_v,size.get(up_v)+size(up_u));
    }
    else{
      parent.set(up_v,up_u);
      rank.set(up_u,size.get(up_v)+size.get(up_u);
    }
  }
};

class Main{
  public static void main(String[] args){
    DisjointSet ds = new DisjointSet(7);
    ds.unionByRank(1,2);
    ds.unionByRank(2,3);
    ds.unionByRank(4,5);
    ds.unionByRank(6,7);
    ds.unionByRank(5,6);
    // if 3 and 7 are in same set?
    if(ds.findUPar(3) == ds.findUPar(7)){
      System.out.println("same");
    else
      Sopln("elle");
    ds.unionByRank(3,7);
  }
}
    
