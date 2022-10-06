class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }else if(arr[mid - 1] < arr[mid] && arr[mid] < arr[mid+1]){
                left = mid;
            } else if(arr[mid-1] > arr[mid] && arr[mid] > arr[mid+1]){
                right = mid;
            }
        }
        if(arr[left]>arr[left-1] && arr[left] > arr[left + 1]){
            return left;
        } 
        if(arr[right] > arr[right-1] && arr[right] > arr[right+1]){
            return right;
        }
        return -1;
    }
}