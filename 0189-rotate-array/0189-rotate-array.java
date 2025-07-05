class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        // for(int i=0;i<(n-k-1)/2;i++){
        //     int temp=nums[i];
        //     nums[i]=nums[n-k-i-1];
        //     nums[n-k-1-i]=temp;
        // }
        // for(int i=0;i<k/2;i++){
        //     int a= n - k + i;
        //     int b= n - 1 - i;
        //     int temp=nums[a];
        //     nums[a]=nums[b];
        //     nums[b]=temp;
        // }
        // for(int i=0;i<(n-1)/2;i++){
        //     int temp=nums[i];
        //     nums[i]=nums[n-i-1];
        //     nums[n-1-i]=temp;
        // }
        if (n == 0 || k == 0) {
            return;
        }
        k=k%n;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }

    public void reverse(int[] nums, int a, int b){
        while(a<b){
            int temp=nums[a];
            nums[a]=nums[b];
            nums[b]=temp;
            a++;
            b--;
        }
    }
}