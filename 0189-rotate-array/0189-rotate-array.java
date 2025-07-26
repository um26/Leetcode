class Solution {
    public void rotate(int[] nums, int k) {
        int l=nums.length;
        k=k%l;
        if(k==0 || l==0) return;
        reverse(nums, 0,l-k-1);
        reverse(nums, l-k,l-1);
        reverse(nums, 0,l-1);
    }
    public void reverse(int nums[], int a, int b){
        while(a<b){
            int temp=nums[a];
            nums[a]=nums[b];
            nums[b]=temp;
            a++;
            b--;
        }
    }
}