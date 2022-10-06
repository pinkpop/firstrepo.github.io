class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int p = indexOfX(arr, x);
        int left = p - 1, right = p;
        LinkedList<Integer> res = new LinkedList<>();
        
        while(right - left - 1 < k){
            if(left == -1){
                res.addLast(arr[right]);
                right++;
            } else if(right == arr.length){
                res.addFirst(arr[left]);
                left --;
            } else if(x-arr[left] > arr[right] - x) {
                res.addLast(arr[right]);
                right ++;
            } else {
                res.addFirst(arr[left]);
                left --;
            }
        }
        return res;
    }
        private int indexOfX(int[] arr, int x){
            //find the index of x
        int left = 0, right = arr.length;
        while(left < right){
            int mid = left + (right - left)/2;
            if(arr[mid] == x){
                right = mid;
            } else if(arr[mid] < x){
                left = mid + 1;
            } else if(arr[mid] > x){
                right = mid;}
        }
           
                return left;
       
    }
}