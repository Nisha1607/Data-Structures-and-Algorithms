Consider an integer matrix. matrix[i][j] represents the height of the Cell. You can move to the Adj Cell 
  if the height of the Adj Cell is less than or equal to the height of the current Cell. 
  Is it possible to reach bottom right from top left ? return boolean result , write it in java


public class MatrixTraversal {
    
    public boolean canReachBottomRight(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; // Matrix is empty
        }
        
        int m = matrix.length; // Number of rows
        int n = matrix[0].length; // Number of columns
        
        boolean[][] visited = new boolean[m][n]; // Keep track of visited cells
        
        // Start DFS from the top-left cell
        return dfs(matrix, visited, 0, 0, Integer.MAX_VALUE);
    }
    
    private boolean dfs(int[][] matrix, boolean[][] visited, int row, int col, int prevHeight) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Check if we reached the bottom-right cell
        if (row == m - 1 && col == n - 1) {
            return true;
        }
        
        // Check if current cell is out of bounds or already visited
        if (row < 0 || col < 0 || row >= m || col >= n || visited[row][col]) {
            return false;
        }
        
        // Check if the height of the current cell is greater than the previous height
        if (matrix[row][col] > prevHeight) {
            return false;
        }
        
        // Mark current cell as visited
        visited[row][col] = true;
        
        // Check if we can move to adjacent cells
        boolean canReach = dfs(matrix, visited, row + 1, col, matrix[row][col]) ||
                           dfs(matrix, visited, row - 1, col, matrix[row][col]) ||
                           dfs(matrix, visited, row, col + 1, matrix[row][col]) ||
                           dfs(matrix, visited, row, col - 1, matrix[row][col]);
                           
        // Unmark current cell after backtracking
        visited[row][col] = false;
        
        return canReach;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {3, 2, 3},
            {2, 4, 6},
            {5, 3, 2}
        };
        
        MatrixTraversal traversal = new MatrixTraversal();
        System.out.println("Is it possible to reach bottom right? " + traversal.canReachBottomRight(matrix));
    }
}
