class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        if(nums == null){
            return res;
        }
        dfs(nums, track);
        return res;
    }
    
    private void dfs(int[] nums, LinkedList<Integer> track){
        if(nums.length == track.size()){
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(track.contains(nums[i])){
                continue;
            }
            track.addLast(nums[i]);
            
            dfs(nums, track);
            
            track.removeLast();
        }
    }
}