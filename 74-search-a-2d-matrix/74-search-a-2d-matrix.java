class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        if(matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] arr = new int[m*n];
        for(int i = 0; i < m*n; i++){
            arr[i] = matrix[i/n][i%n];
        }
        int left = 0, right = arr.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(arr[mid] == target){
                return true;
            } else if(arr[mid] < target){
                left = mid;
            } else {
                right = mid;
            }
        }
        if(arr[left] == target || arr[right] == target){
            return true;
        } else return false;
        
        
//         if(matrix == null || matrix.length == 0){
//             return false;
//         }
//         if(matrix[0] == null || matrix[0].length == 0){
//             return false;
//         }
        
//         int row = matrix.length;
//         int col = matrix[0].length;
        
//         int start = 0, end = row - 1;
//         while(start + 1 < end){
//             int mid = start + (end-start)/2;
//             if(matrix[mid][0] == target){
//                 return true;
//             }
//             else if(matrix[mid][0] < target){
//                 start = mid;
//             } else {
//                 end = mid;
//             }
//         }
//         if(matrix[end][0] <= target){
//             row = end;
//         } else if(matrix[start][0] <= target){
//             row = start;
//         } else return false;
        
//         start = 0; 
//         end = col - 1;
//          while(start + 1 < end){
//             int mid = start + (end-start)/2;
//             if(matrix[row][mid] == target){
//                 return true;
//             } else if(matrix[row][mid] < target){
//                 start = mid;
//             } else {
//                 end = mid;
//             }
//         }
//          if(matrix[row][start] == target){
//             return true;
//         } else if(matrix[row][end] == target){
//             return true;
//         } else return false;
        
    }
}