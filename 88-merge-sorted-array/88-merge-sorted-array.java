class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m -1, j = n - 1;
        int k = nums1.length - 1;
        
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        
        while(j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
        
        
        
        
        
        
        // int k = m + n;
        // int[] temp = new int[k];
        // for (int index = 0, nums1Index = 0, nums2Index = 0; index < k; index ++){
        //     if(nums1Index >= m){
        //         temp[index] = nums2[nums2Index++];
        //     } else if(nums2Index >= n){
        //         temp[index] = nums1[nums1Index++];
        //     } else if(nums1[nums1Index] < nums2[nums2Index]){
        //         temp[index] = nums1[nums1Index++];
        //     } else temp[index] = nums2[nums2Index++];
        // }
        // for (int i = 0; i< k; i++){
        //     nums1[i] = temp[i];
        // }
    }
}