class Solution {
    public int[] searchRange(int[] nums, int target) {
       //做两次二分分别确定左右边界
       if(nums.length < 1 || nums == null){
           return new int[]{-1, -1};
       }
        int[] res = new int[2];
        
        //find left boundary
        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= target){
                right = mid;
            } else {
                left = mid;
            } 
        }
        
        if(nums[left] != target && nums[right] != target){
            return new int[]{-1, -1};
        }
        if(nums[left] == target){
            res[0] = left;
        } else {
            res[0] = right;
        }
        
        //find right boundary
        left = 0 ; right = nums.length - 1;
          while( left + 1 < right) {
            int mid = left + (right - left)/2;
            
            if( nums[mid] <= target) {
               left = mid;
            } else{
                right = mid;
            }
        }
        
        if(nums[right] == target ) {
            res[1] = right;
        } else if(nums[left] == target) {
            res[1] = left;
        }
        return res;
    }
}