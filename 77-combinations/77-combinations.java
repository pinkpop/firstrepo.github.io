class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 1, k);
        return res;
    }
    private void backtrack(int n, int startIndex, int k){
        if(k == track.size()){
             res.add(new LinkedList<>(track));
            return;
        }
       
        for(int i = startIndex; i <= n; i++){
            track.addLast(i);
            backtrack(n, i + 1, k);
            track.removeLast();
        }
    }
}