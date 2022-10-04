class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //先对宽度进行排序，再找出高度的LIS就是答案
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
            });
        int[] height = new int[n];
        for(int i = 0; i < n; i++){
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }
    
        public int lengthOfLIS(int[] nums){
            int piles = 0, n = nums.length;
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            // 要处理的扑克牌
            int poker = nums[i];
            int left = 0, right = piles;
            // 二分查找插入位置
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= poker)
                    right = mid;
                else
                    left = mid + 1;
            }
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
            
        }
}
                    