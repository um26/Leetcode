class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while(i<j){
            if(target-numbers[i]-numbers[j]==0){
                return new int[]{i+1,j+1};
            }
            else if(target-numbers[i]-numbers[j]>0){
                i++;
            }
            else{j--;}
        }
        return null;
    }
}