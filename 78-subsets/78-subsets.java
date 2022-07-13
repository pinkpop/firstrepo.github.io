class Solution {
     List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return res;
        }
        backtrack(nums, 0);
        return res;
    }
    
    private void backtrack(int[] nums, int startIndex){
        res.add(new LinkedList<>(track));
        
        for(int i = startIndex; i < nums.length; i++){
            track.addLast(nums[i]);
            backtrack(nums, i+1);
            track.removeLast();
        }
    }
}