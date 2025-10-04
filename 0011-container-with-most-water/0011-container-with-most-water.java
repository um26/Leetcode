class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1, maxarea=0;

        while(j>=i){
            int area= (j-i)*(Math.min(height[j],height[i]));
            if(area>maxarea){
                maxarea=area;
            }
            if(height[j]>height[i]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxarea;
    }
}