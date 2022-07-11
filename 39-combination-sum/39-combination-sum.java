class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return results;
        }
        int[] nums = removeDuplicate(candidates);
        dfs(nums, 0, new ArrayList<Integer>(), target, results);
        return results;
        
    }
    
    private void dfs(int[] nums, int startIndex, List<Integer> combination, int target, List<List<Integer>> results){
        if(target == 0){
            results.add(new ArrayList<Integer>(combination));
            return;
        }
        for(int i = startIndex; i <nums.length; i++){
            if(nums[i] > target){
                break;
            }
            combination.add(nums[i]);
            dfs(nums, i, combination, target- nums[i], results);
            combination.remove(combination.size() - 1);
        }
        
    }
    
    private int[] removeDuplicate(int[] candidates){
        Arrays.sort(candidates);
        
        int index = 0;
        for(int i = 0; i < candidates.length; i++){
            if(candidates[i] != candidates[index]){
                candidates[++index] = candidates[i];
            }
        }
        int[] nums = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            nums[i] = candidates[i];
        }
        
        return nums;
    }
}