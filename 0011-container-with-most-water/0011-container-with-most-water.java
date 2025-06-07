class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max=0;
        while(j>i){
                if(max< Math.min(height[i],height[j])*(j-i)){
                    max= Math.min(height[i],height[j])*(j-i);
                }
                if(height[i]<=height[j]){
                    i++;
                }
                else{
                    j--;
                }
            
        }
        return max;

        // int n=height.length;
        // int maxarea=0;
        // for(int i=0;i<n-1;i++){
        //     for(int j=i+1;j<n;j+=1){
        //         int minheight=Math.min(height[i],height[j]);
        //         int width=j-i;
        //         int area=minheight*width;
        //         if(area>maxarea){
        //             maxarea=area;
        //         }
        //     }
        // }
        // return maxarea;
    }
}