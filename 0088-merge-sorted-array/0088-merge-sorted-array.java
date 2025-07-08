class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums= new int[m+n];
        int j=0,k=0;
        for(int i=0;i<m+n;i++){
            if(j==m){
                nums[i]=nums2[k];
                k++;
            }
            else if(k==n){
                nums[i]=nums1[j];
                j++;
            }
            else if(nums1[j]<=nums2[k]){
                nums[i]=nums1[j];
                j++;
            } else{
                nums[i]=nums2[k];
                k++;
            }
        }

        for(int i=0;i<m+n;i++){
            nums1[i]=nums[i];
        }
    }
}