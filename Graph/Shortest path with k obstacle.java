   class Cell{
        int x;
        int y;
        int k;
        Cell(int x,int y,int k){
            this.x=x;
            this.y=y;
            this.k=k;
        }
    }

    boolean isSafe(int x, int y, int m,int n){
        if(x<0 || y<0 || x>=m || y>=n ) return false;
        return true;
    }

    public int shortestPath(int[][] grid, int k) {
        Queue<Cell> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        q.add(new Cell(0,0,k));

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int steps=0;
        boolean[][][] visited = new boolean[m][n][k+1];
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size > 0){
                Cell cell = q.poll();
                int x = cell.x;
                int y = cell.y;
                int tk = cell.k;
                visited[x][y][tk]=true;
                if(x==m-1 && y==n-1 && tk>=0) return steps;
                for(int i=0;i<4;i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    int nk = tk;
                    if(isSafe(nx,ny,m,n) && !visited[nx][ny][nk] && grid[nx][ny] == 0){
                        q.add(new Cell(nx,ny,nk));
                        visited[nx][ny][nk]=true;
                    }
                     if(isSafe(nx,ny,m,n) && nk>0 && !visited[nx][ny][nk-1] && grid[nx][ny] == 1){
                        q.add(new Cell(nx,ny,nk-1));
                        visited[nx][ny][nk-1]=true;
                    }
                }
                size--;
            }
            steps++;
        }
        return -1;
    }
