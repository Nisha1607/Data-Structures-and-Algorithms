public class Solution {

	static class DisjointSet{
		List<Integer> sizes = new ArrayList<>();
		List<Integer> parents = new ArrayList<>();

		public DisjointSet(int n){
			for(int i=0;i<n;i++){
				parents.add(i);
				sizes.add(1);

			}
		}

		public int findUPar(int node){
			if(node==parents.get(node)){
				return node;
			}
			parents.set(node,findUPar(parents.get(node)));
			return parents.get(node);
		}

		public void unionBySize(int u,int v){
			int up_u = findUPar(u);
			int up_v = findUPar(v);
			if(up_u==up_v) return;
			if(sizes.get(up_u)<sizes.get(up_v)){
				parents.set(up_u,up_v);
				sizes.set(up_v,sizes.get(up_v)+sizes.get(up_u));
			}
			else{
				parents.set(up_v,up_u);
				sizes.set(up_u,sizes.get(up_v)+sizes.get(up_u));
			}
		}
		
	}
	public static int minTime(int[][] logs, int n) {
		// Write your code here.
		Arrays.sort(logs,(a,b)->a[0]-b[0]);
		 DisjointSet ds = new DisjointSet(n);

        int minTime=0;
		boolean[] vis = new boolean[n];
		for(int i=0;i<n;i++){
			for(int[] log : logs){
				int idA = log[1];
				int idB = log[2];
				int time = log[0];
				if(ds.findUPar(idA)!=ds.findUPar(idB)){
					minTime=time;
					vis[idB]=true;
					vis[idA]=true;
					 ds.unionBySize(idA,idB);
				}
			}
		}
		   for(int i = 0; i < n; i++) {

        if(vis[i] == false) return -1;

    }
		return minTime;

	}
}

