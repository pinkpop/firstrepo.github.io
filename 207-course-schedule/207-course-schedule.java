class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] edge:prerequisites){
            graph[edge[1]].add(edge[0]);
            inDegree[edge[0]]++;
        }
        //遍历次数
        int numChoose = 0;
        Queue queue = new LinkedList();
        
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int cur = (int)queue.poll();
            numChoose ++;
            for(int i = 0; i < graph[cur].size(); i++){
                int next = (int)graph[cur].get(i);
                inDegree[next]--;
                if(inDegree[next] == 0){
                    queue.add(next);
                }
            }
        }
        return numChoose == numCourses;
    }
}