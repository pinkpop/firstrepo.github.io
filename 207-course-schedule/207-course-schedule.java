class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //建立图
        List[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        //计算每个点的入度
        for(int[] edge:prerequisites){
            graph[edge[1]].add(edge[0]);
            inDegree[edge[0]]++;
        }
       
        //numChoose为访问过的点
        int numChoose = 0;
        Queue queue = new LinkedList();
        
        //将indegree为0的点加入队列
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            //将当前点弹出，访问过的点+1
            int cur = (int)queue.poll();
            numChoose ++;
            for(int i = 0; i < graph[cur].size(); i++){
                //访问当前点指向的下一个点
                int next = (int)graph[cur].get(i);
                //将此点的入度减一
                inDegree[next]--;
                //如果该点入度为0，则加入队列
                if(inDegree[next] == 0){
                    queue.add(next);
                }
            }
        }
        return numChoose == numCourses;
    }
}