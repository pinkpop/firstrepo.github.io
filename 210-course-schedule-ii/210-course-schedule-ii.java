class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] edge : prerequisites){
            graph[edge[1]].add(edge[0]);
            inDegree[edge[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        
       for(int i= 0; i < numCourses; i++){
           if(inDegree[i] == 0){
               queue.offer(i);
           }
       }
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            res[count] = cur;
            count++;
            for(int next : graph[cur]){
                inDegree[next]--;
                if(inDegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        if (count != numCourses) {
        // 存在环，拓扑排序不存在
        return new int[]{};
    }
        return res;
    }
}