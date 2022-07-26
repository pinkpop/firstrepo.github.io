class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //hashmap
        if(nums1 == null || nums2 == null){
            return null;
        }
        HashSet<Integer> hash = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            hash.add(nums1[i]);
        }
        
        HashSet<Integer> resultHash = new HashSet<>();
        for (int j = 0; j < nums2.length; j++){
            if(hash.contains(nums2[j]) && !resultHash.contains(nums2[j])){
                resultHash.add(nums2[j]);
            }
        }
        
        int index = 0;
        int size = resultHash.size();
        int[] result = new int[size];
        for(Integer num : resultHash){
            result[index++] = num;
        }
        return result;
    }
}