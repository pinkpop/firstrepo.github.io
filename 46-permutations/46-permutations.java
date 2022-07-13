class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null){
            return res;
        }
        dfs(nums, new boolean[nums.length], new LinkedList<Integer>(), res);
        return res;
    }
    
    private void dfs(int[] nums, boolean[] visited, LinkedList<Integer> permutation,                                        List<List<Integer>> res){
        if(nums.length == permutation.size()){
            res.add(new LinkedList<>(permutation));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            permutation.addLast(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, res);
            visited[i] = false;
            permutation.removeLast();
        }
    }
}