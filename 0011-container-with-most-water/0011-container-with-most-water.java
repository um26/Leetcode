class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int maxarea=0;
        while(j>=i){
            int area= (j-i)*(Math.min(height[i],height[j]));
            if(area>maxarea){
                maxarea=area;
            }
            if(height[i]>=height[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return maxarea;
    }
}